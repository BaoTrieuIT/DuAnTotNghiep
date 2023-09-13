package com.poly.website_norulesshop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class CategoryController {
    @RequestMapping("category")
    public String index (){
        return "user/category";
    }
}
