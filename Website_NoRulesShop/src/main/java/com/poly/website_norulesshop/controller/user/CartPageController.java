package com.poly.website_norulesshop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class CartPageController {
    @RequestMapping("cart-page")
    public String index(Model model) {
        model.addAttribute("title", "Giỏ hàng");
        return "user/cart_page";
    }
}
