package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderDetailService {
    OrderDetail saveOrderDetail(OrderDetail orderDetail);

    OrderDetail getOrderDetailById(Long id);

    List<OrderDetail> getAllOrderDetails();

    void deleteOrderDetail(Long id);
}
