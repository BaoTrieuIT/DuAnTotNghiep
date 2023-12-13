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
import com.poly.website_norulesshop.entity.OrderStatus;
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
    private final OrderStatusService orderStatusService;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ProductService productService, AccountService accountService, CategoryQuantityService categoryQuantityService, OrderStatusService orderStatusService) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productService = productService;
        this.accountService = accountService;
        this.categoryQuantityService = categoryQuantityService;
        this.orderStatusService = orderStatusService;
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
    public void deleteById(Integer orderId) {
        try {
            orderRepository.deleteById(orderId);
            System.out.println("Order deleted successfully");
        } catch (Exception e) {
            System.err.println("Error deleting order: " + e.getMessage());
        }
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
                .map(data -> new OrderDTO((int) data[0], (int) data[1], (Long) data[2]))
                .collect(Collectors.toList());
    }


    @Override
    public List<Order> getOrderAwaitingConfirmation() {
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(1);
        List<Order> result = orderRepository.findByOrderStatus(orderStatus);
        return result;
    }

    @Override
    public List<Order> getOrderHasBeenShipped() {
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(2);
        List<Order> result = orderRepository.findByOrderStatus(orderStatus);
        return result;
    }

    @Override
    public List<Order> getOrderInTransit() {
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(3);
        List<Order> result = orderRepository.findByOrderStatus(orderStatus);
        return result;
    }

    @Override
    public List<Order> getOrderDeliveryComplete() {
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(4);
        List<Order> result = orderRepository.findByOrderStatus(orderStatus);
        return result;
    }

    @Override
    public List<Order> getOrderHasBeenCanceled() {
        OrderStatus orderStatus = orderStatusService.getOrderStatusById(5);
        List<Order> result = orderRepository.findByOrderStatus(orderStatus);
        return result;
    }
}
