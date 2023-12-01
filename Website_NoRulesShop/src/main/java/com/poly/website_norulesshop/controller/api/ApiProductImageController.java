package com.poly.website_norulesshop.controller.api;

import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.entity.ProductImage;
import com.poly.website_norulesshop.service.ProductImageService;
import com.poly.website_norulesshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/productImages")
public class ApiProductImageController {
    @Autowired
    ProductImageService productImageService;

    @GetMapping("{productId}")
    public List<ProductImage> getOne(@PathVariable("productId") Integer id) {
        return productImageService.findImageUrlByProductId(id);
    }
}
