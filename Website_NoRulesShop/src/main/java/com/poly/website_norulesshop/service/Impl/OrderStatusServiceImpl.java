package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.OrderStatusRepository;
import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.entity.OrderStatus;
import com.poly.website_norulesshop.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public OrderStatus saveOrderStatus(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus getOrderStatusById(Integer id) {
        return orderStatusRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusRepository.findAll();
    }

    @Override
    public void deleteOrderStatus(Integer id) {
        orderStatusRepository.deleteById(id);
    }

    @Override
    public OrderStatus getByOrderStatusName(String OrderStatusName) {
        return orderStatusRepository.findByOrderStatusName(OrderStatusName);
    }
}
