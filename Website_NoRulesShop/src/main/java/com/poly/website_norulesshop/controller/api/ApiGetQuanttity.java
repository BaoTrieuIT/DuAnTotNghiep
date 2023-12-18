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

    @GetMapping("{productId}/{categoryQuantityId}")
    public Integer getQuantity(@PathVariable("productId") Integer productId,
                               @PathVariable("categoryQuantityId") Integer categoryQuantityId) {
        return categoryQuantityService.getTotalQuantity(productId, categoryQuantityId);

    }


}
