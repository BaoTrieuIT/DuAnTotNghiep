package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.OrderDetailRepository;
import com.poly.website_norulesshop.model.OrderDetail;
import com.poly.website_norulesshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
