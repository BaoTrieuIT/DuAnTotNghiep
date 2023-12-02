package com.poly.website_norulesshop.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.website_norulesshop.Repository.OrderDetailRepository;
import com.poly.website_norulesshop.Repository.OrderRepository;
import com.poly.website_norulesshop.entity.CategoryQuantity;
import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.entity.OrderDetail;
import com.poly.website_norulesshop.service.CategoryQuantityService;
import com.poly.website_norulesshop.service.OrderDetailService;
import com.poly.website_norulesshop.service.OrderService;
import com.poly.website_norulesshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductService productService;

    private final CategoryQuantityService categoryQuantityService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ProductService productService, CategoryQuantityService categoryQuantityService) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productService = productService;
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
//        CategoryQuantity categoryQuantity = categoryQuantityService.findByProduct(categorylv1detail,categorylv2detail,order.get)
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmm");
        String formattedDate = dateFormat.format(new Date());
        order.setTradingCode("NR" + formattedDate);
        orderRepository.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
        };
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetailList"), type)
                .stream().peek(d -> d.setOrder(order)).toList();
        orderDetailRepository.saveAll(details);
        System.out.println();
        return order;
    }

    @Override
    public Order createDataWithVnPay(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData, Order.class);
//        CategoryQuantity categoryQuantity = categoryQuantityService.findByProduct(categorylv1detail,categorylv2detail,order.get)
//        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmm");
//        String formattedDate = dateFormat.format(new Date());
//        order.setTradingCode("NR" + formattedDate);
//        orderRepository.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
        };
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetailList"), type)
                .stream().peek(d -> d.setOrder(order)).toList();
//        orderDetailRepository.saveAll(details);
        return order;
    }
}
