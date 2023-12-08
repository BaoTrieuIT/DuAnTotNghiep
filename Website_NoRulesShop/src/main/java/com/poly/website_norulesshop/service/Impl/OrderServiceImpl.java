package com.poly.website_norulesshop.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.website_norulesshop.Repository.OrderDetailRepository;
import com.poly.website_norulesshop.Repository.OrderRepository;
import com.poly.website_norulesshop.dto.OrderDTO;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.entity.OrderDetail;
import com.poly.website_norulesshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductService productService;
    private final AccountService accountService;
    private final CategoryQuantityService categoryQuantityService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ProductService productService, AccountService accountService, CategoryQuantityService categoryQuantityService) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productService = productService;
        this.accountService = accountService;
        this.categoryQuantityService = categoryQuantityService;

    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findByUserId(Integer accountId) {
        return orderRepository.findByAccountId(accountId);
    }

    @Override
    public Order createData(JsonNode orderData) {


        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData, Order.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmm");
        String formattedDate = dateFormat.format(new Date());
        order.setTradingCode("NR" + formattedDate);
        orderRepository.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
        };
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetailList"), type)
                .stream().peek(d -> d.setOrder(order)).toList();
        orderDetailRepository.saveAll(details);
        return order;
    }

    @Override
    public Order createDataWithVnPay(JsonNode orderData, Integer id, String code) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Order order = mapper.convertValue(orderData, Order.class);
            Account account = accountService.getAccountById(id);
            order.setAccount(account);
            order.setTradingCode(code);
            orderRepository.save(order);
            TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
            };
            List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetailList"), type)
                    .stream().peek(d -> d.setOrder(order)).toList();
            orderDetailRepository.saveAll(details);
            return order;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Integer totalRevenue(String time) {
        return switch (time) {
            case "revenue_today" -> orderRepository.countRevenueAndToday();
            case "revenue_month" -> orderRepository.countRevenueAndMonth();
            case "revenue_year" -> orderRepository.countRevenueAndYear();
            default -> throw new RuntimeException();
        };
    }

    @Override
    public List<OrderDTO> getAllOrdersDashboard() {
        List<Object[]> revenueList = orderRepository.getRevenueByMonth();
        return revenueList.stream()
                .map(data -> new OrderDTO((int) data[0], (int) data[1], (BigDecimal) data[2]))
                .collect(Collectors.toList());
    }
}
