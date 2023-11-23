package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.CategoryQuantity;
import com.poly.website_norulesshop.entity.ProductImage;
import com.poly.website_norulesshop.service.CategoryQuantityService;
import com.poly.website_norulesshop.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categoryQuantity")
public class ApiCategoryQuantityController {
    @Autowired
    CategoryQuantityService categoryQuantityService;

    @GetMapping("{productId}/{categoryLv1Id}/{categoryLv2Id}")
    public CategoryQuantity getOne(@PathVariable("productId") Integer productId,
                                   @PathVariable("categoryLv1Id") Integer categoryLv1Id,
                                   @PathVariable("categoryLv2Id") Integer categoryLv2Id) {
        return categoryQuantityService.filter(productId, categoryLv1Id, categoryLv2Id);
    }
}
