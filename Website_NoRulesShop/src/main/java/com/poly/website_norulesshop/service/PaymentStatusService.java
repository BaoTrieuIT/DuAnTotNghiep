package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.PaymentStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaymentStatusService {
    PaymentStatus savePaymentStatus(PaymentStatus paymentStatus);

    PaymentStatus getPaymentStatusById(Long id);

    List<PaymentStatus> getAllPaymentStatuses();

    void deletePaymentStatus(Long id);
}
