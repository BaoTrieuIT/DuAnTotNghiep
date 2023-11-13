package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ApiProductController {
    @Autowired
    ProductService productService;

    @GetMapping("{productId}")
    public Product getOne(@PathVariable("productId") Integer id) {
        return productService.getProductById(id);
    }
}
