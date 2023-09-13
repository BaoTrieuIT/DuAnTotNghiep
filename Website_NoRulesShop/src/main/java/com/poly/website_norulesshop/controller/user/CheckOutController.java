package com.poly.website_norulesshop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class CheckOutController {
    @RequestMapping("checkout_page")
    public String index (){
        return "user/checkout_page";
    }
}
