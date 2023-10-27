package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaymentMethodService {
    PaymentMethod savePaymentMethod(PaymentMethod paymentMethod);

    PaymentMethod getPaymentMethodById(Long id);

    List<PaymentMethod> getAllPaymentMethods();

    void deletePaymentMethod(Long id);
}
