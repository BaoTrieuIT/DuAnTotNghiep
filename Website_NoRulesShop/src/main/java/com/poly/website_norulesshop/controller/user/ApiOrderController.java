package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.CategoryQuantity;
import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.service.CategoryQuantityService;
import com.poly.website_norulesshop.service.OrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/order")
public class ApiOrderController {
    @Autowired
    OrderService orderService;
    Map<String, Boolean> softMap = new HashMap<>();
    List<Order> listOrder = new ArrayList<>();

    @PostConstruct
    public void init() {
        softMap.put("orderId", true);
        softMap.put("custormerName", true);
        softMap.put("orderTime", true);
        softMap.put("discountAmout", true);
        softMap.put("recipientName", true);

        softMap.put("phoneNumber", true);
        softMap.put("specifiedAddress", true);
        softMap.put("confirmation", true);
    }
}
