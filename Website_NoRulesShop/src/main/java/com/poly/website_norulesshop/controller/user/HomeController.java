package com.poly.website_norulesshop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "Trang chủ");
        return "user/index";
    }
}
