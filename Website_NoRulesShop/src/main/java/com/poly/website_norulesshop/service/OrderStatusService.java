package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderStatusService {
    OrderStatus saveOrderStatus(OrderStatus orderStatus);

    OrderStatus getOrderStatusById(Long id);

    List<OrderStatus> getAllOrderStatuses();

    void deleteOrderStatus(Long id);
}
