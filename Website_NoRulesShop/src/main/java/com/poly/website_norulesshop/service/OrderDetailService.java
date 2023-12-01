package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    OrderDetail saveOrderDetail(OrderDetail orderDetail);

    OrderDetail getOrderDetailById(Integer id);

    List<OrderDetail> getAllOrderDetails();

    void deleteOrderDetail(Integer id);

    List<OrderDetail> findByOrderId(Integer orderId);
}
