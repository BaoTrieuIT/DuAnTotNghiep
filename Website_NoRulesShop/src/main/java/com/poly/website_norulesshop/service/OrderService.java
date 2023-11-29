package com.poly.website_norulesshop.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.website_norulesshop.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order saveOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    void deleteOrder(Long id);

    Order createData(JsonNode orderData);
}
