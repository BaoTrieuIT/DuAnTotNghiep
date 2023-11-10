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

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }
}
