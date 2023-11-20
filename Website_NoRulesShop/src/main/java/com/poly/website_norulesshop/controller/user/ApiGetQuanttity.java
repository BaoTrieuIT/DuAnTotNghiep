package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/getMaxQty")
public class ApiGetQuanttity {
    @Autowired
    ProductService productService;

    @GetMapping("{productId}")
    public Integer getQuantity(@PathVariable("productId") Integer productId) {
        return productService.getTotalQuantity(productId);

    }


}
