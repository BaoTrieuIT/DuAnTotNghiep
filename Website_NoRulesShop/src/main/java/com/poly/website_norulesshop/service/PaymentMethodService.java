package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.PaymentMethod;
@Service
public interface PaymentMethodService {
    PaymentMethod savePaymentMethod(PaymentMethod paymentMethod);

    PaymentMethod getPaymentMethodById(Integer id);

    List<PaymentMethod> getAllPaymentMethods();

    void deletePaymentMethod(Integer id);
}
