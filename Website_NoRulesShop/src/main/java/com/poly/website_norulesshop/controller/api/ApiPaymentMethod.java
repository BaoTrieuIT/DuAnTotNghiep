package com.poly.website_norulesshop.controller.api;

import com.poly.website_norulesshop.entity.PaymentMethod;
import com.poly.website_norulesshop.service.CategoryQuantityService;
import com.poly.website_norulesshop.service.PaymentMethodService;
import com.poly.website_norulesshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/paymenMethod")
public class ApiPaymentMethod {
    @Autowired
    PaymentMethodService paymentMethodService;

    @GetMapping()
    public List<PaymentMethod> getAll() {
        return paymentMethodService.getAllPaymentMethods();

    }


}
