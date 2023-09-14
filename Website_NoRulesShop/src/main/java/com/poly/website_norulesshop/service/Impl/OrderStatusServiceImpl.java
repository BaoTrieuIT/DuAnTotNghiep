package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.OrderStatusRepository;
import com.poly.website_norulesshop.model.OrderStatus;
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
    public OrderStatus getOrderStatusById(Long id) {
        return orderStatusRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusRepository.findAll();
    }

    @Override
    public void deleteOrderStatus(Long id) {
        orderStatusRepository.deleteById(id);
    }
}
