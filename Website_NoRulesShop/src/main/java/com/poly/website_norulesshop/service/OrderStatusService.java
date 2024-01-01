package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.OrderStatus;

@Service
public interface OrderStatusService {
    OrderStatus saveOrderStatus(OrderStatus orderStatus);

    OrderStatus getOrderStatusById(Integer id);

    List<OrderStatus> getAllOrderStatuses();

    void deleteOrderStatus(Integer id);


    OrderStatus getByOrderStatusName(String OrderStatusName);
}
