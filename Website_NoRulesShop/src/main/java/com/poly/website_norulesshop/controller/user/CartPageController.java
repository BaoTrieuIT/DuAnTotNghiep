package com.poly.website_norulesshop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class CartPageController {
    @RequestMapping("cart-page")
    public String index (){
        return "user/cart_page";
    }
}
