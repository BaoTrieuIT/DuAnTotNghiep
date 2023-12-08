package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.entity.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderStatusService {
    OrderStatus saveOrderStatus(OrderStatus orderStatus);

    OrderStatus getOrderStatusById(Integer id);

    List<OrderStatus> getAllOrderStatuses();

    void deleteOrderStatus(Integer id);


    OrderStatus getByOrderStatusName(String OrderStatusName);
}
