package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.DeliveryMethodRepository;
import com.poly.website_norulesshop.model.DeliveryMethod;
import com.poly.website_norulesshop.service.DeliveryMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryMethodServiceImpl implements DeliveryMethodService {

    private final DeliveryMethodRepository deliveryMethodRepository;

    @Autowired
    public DeliveryMethodServiceImpl(DeliveryMethodRepository deliveryMethodRepository) {
        this.deliveryMethodRepository = deliveryMethodRepository;
    }

    @Override
    public DeliveryMethod saveDeliveryMethod(DeliveryMethod deliveryMethod) {
        return deliveryMethodRepository.save(deliveryMethod);
    }

    @Override
    public DeliveryMethod getDeliveryMethodById(Long id) {
        return deliveryMethodRepository.findById(id).orElse(null);
    }

    @Override
    public List<DeliveryMethod> getAllDeliveryMethods() {
        return deliveryMethodRepository.findAll();
    }

    @Override
    public void deleteDeliveryMethod(Long id) {
        deliveryMethodRepository.deleteById(id);
    }
}
