package com.poly.website_norulesshop.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.website_norulesshop.dto.OrderDTO;
import com.poly.website_norulesshop.entity.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {
    Order saveOrder(Order order);

    Order getOrderById(Integer id);

    List<Order> getAllOrders();

    void deleteOrder(Integer id);

    List<Order> findByUserId(Integer accountId);

    Order createData(JsonNode orderData);

    Order createDataWithVnPay(JsonNode orderData, Integer id, String code);

    Integer totalRevenue(String time);


    List<OrderDTO> getAllOrdersDashboard();

    List<Order> getOrderAwaitingConfirmation();

    List<Order> getOrderHasBeenShipped();

    List<Order> getOrderInTransit();

    List<Order> getOrderDeliveryComplete();

    List<Order> getOrderHasBeenCanceled();
}
