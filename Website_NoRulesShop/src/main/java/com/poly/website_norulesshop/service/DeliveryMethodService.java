package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.DeliveryMethod;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DeliveryMethodService {
    DeliveryMethod saveDeliveryMethod(DeliveryMethod deliveryMethod);

    DeliveryMethod getDeliveryMethodById(Long id);

    List<DeliveryMethod> getAllDeliveryMethods();

    void deleteDeliveryMethod(Long id);
}
