package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.OrderDetailRepository;
import com.poly.website_norulesshop.entity.OrderDetail;
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
    public OrderDetail getOrderDetailById(Integer id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public void deleteOrderId(Integer id) {
        try {
            orderDetailRepository.deleteByOrderId(id);
            System.out.println("orderDetailRepository deleted successfully");
        } catch (Exception e) {
            System.err.println("Error deleting orderDetailRepository: " + e.getMessage());
        }
    }

    @Override
    public List<OrderDetail> findByOrderId(Integer orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    @Override
    public Integer totalSales(String time) {
        return switch (time) {
            case "sales_today" -> orderDetailRepository.countSalesAndToday();
            case "sales_month" -> orderDetailRepository.countSalesAndMonth();
            case "sales_year" -> orderDetailRepository.countSalesAndYear();
            default -> throw new RuntimeException();
        };
    }
}
