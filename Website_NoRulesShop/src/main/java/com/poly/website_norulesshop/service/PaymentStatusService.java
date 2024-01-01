package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.PaymentStatus;
@Service
public interface PaymentStatusService {
    PaymentStatus savePaymentStatus(PaymentStatus paymentStatus);

    PaymentStatus getPaymentStatusById(Integer id);

    List<PaymentStatus> getAllPaymentStatuses();

    void deletePaymentStatus(Integer id);
}
