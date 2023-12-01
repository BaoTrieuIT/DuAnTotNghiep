package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.CategoryQuantity;
import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.entity.ProductImage;
import com.poly.website_norulesshop.service.CategoryQuantityService;
import com.poly.website_norulesshop.service.ProductImageService;
import com.poly.website_norulesshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ApiCategoryQuantityController {
    @Autowired
    CategoryQuantityService categoryQuantityService;
    @Autowired
    ProductService productService;

    @GetMapping("/rest/categoryQuantity/{productId}/{categoryLv1Id}/{categoryLv2Id}")
    public List<CategoryQuantity> getOne(@PathVariable("productId") Integer productId,
                                         @PathVariable("categoryLv1Id") Integer categoryLv1Id,
                                         @PathVariable("categoryLv2Id") Integer categoryLv2Id) {
        return categoryQuantityService.filterList(productId, categoryLv1Id, categoryLv2Id);
    }

    @PostMapping("/rest/categoryQuantitywhenAdd/{productId}/{categoryLv1Id}/{categoryLv2Id}/{quantity}")
    public CategoryQuantity updateQuantitywhenAdd(@PathVariable("productId") Integer productId,
                                                  @PathVariable("categoryLv1Id") Integer categoryLv1Id,
                                                  @PathVariable("categoryLv2Id") Integer categoryLv2Id,
                                                  @PathVariable("quantity") Integer quantity) {
        CategoryQuantity categoryQuantity = categoryQuantityService.getOne(productId, categoryLv1Id, categoryLv2Id);
        categoryQuantity.setQuantity(categoryQuantity.getQuantity() - quantity);
        Product product = productService.getProductById(productId);
        product.setTotalQuantity(product.getTotalQuantity() - quantity);
        productService.saveProduct(product);
        return categoryQuantityService.saveCategoryQuantity(categoryQuantity);
    }

    @PostMapping("/rest/categoryQuantitywhenRemove/{productId}/{categoryLv1Id}/{categoryLv2Id}/{quantity}")
    public CategoryQuantity updateQuantitywhenRemove(@PathVariable("productId") Integer productId,
                                                     @PathVariable("categoryLv1Id") Integer categoryLv1Id,
                                                     @PathVariable("categoryLv2Id") Integer categoryLv2Id,
                                                     @PathVariable("quantity") Integer quantity) {
        CategoryQuantity categoryQuantity = categoryQuantityService.getOne(productId, categoryLv1Id, categoryLv2Id);
        categoryQuantity.setQuantity(categoryQuantity.getQuantity() + quantity);
        Product product = productService.getProductById(productId);
        product.setTotalQuantity(product.getTotalQuantity() + quantity);
        productService.saveProduct(product);
        return categoryQuantityService.saveCategoryQuantity(categoryQuantity);
    }
}
