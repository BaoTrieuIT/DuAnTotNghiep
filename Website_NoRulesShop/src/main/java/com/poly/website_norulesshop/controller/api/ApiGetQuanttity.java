package com.poly.website_norulesshop.controller.api;

import com.poly.website_norulesshop.service.CategoryQuantityService;
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
    @Autowired
    CategoryQuantityService categoryQuantityService;

    @GetMapping("{productId}/{categoryLv1Id}/{categoryLv2Id}")
    public Integer getQuantity(@PathVariable("productId") Integer productId,
                               @PathVariable("categoryLv1Id") Integer categoryLv1Id,
                               @PathVariable("categoryLv2Id") Integer categoryLv2Id) {
        return categoryQuantityService.getTotalQuantity(productId, categoryLv1Id, categoryLv2Id);

    }


}
