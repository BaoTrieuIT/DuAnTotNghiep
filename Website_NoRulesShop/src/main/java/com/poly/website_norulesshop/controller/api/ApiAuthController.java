package com.poly.website_norulesshop.controller.api;

import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ApiAuthController {
    @GetMapping("/rest/login/authentication")
    @ResponseBody
    public Object getAuthentication(HttpSession session) {
        return session.getAttribute("acc");
    }
}
