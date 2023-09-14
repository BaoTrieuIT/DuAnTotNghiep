package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.PaymentStatusRepository;
import com.poly.website_norulesshop.model.PaymentStatus;
import com.poly.website_norulesshop.service.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {

    private final PaymentStatusRepository paymentStatusRepository;

    @Autowired
    public PaymentStatusServiceImpl(PaymentStatusRepository paymentStatusRepository) {
        this.paymentStatusRepository = paymentStatusRepository;
    }

    @Override
    public PaymentStatus savePaymentStatus(PaymentStatus paymentStatus) {
        return paymentStatusRepository.save(paymentStatus);
    }

    @Override
    public PaymentStatus getPaymentStatusById(Long id) {
        return paymentStatusRepository.findById(id).orElse(null);
    }

    @Override
    public List<PaymentStatus> getAllPaymentStatuses() {
        return paymentStatusRepository.findAll();
    }

    @Override
    public void deletePaymentStatus(Long id) {
        paymentStatusRepository.deleteById(id);
    }
}
