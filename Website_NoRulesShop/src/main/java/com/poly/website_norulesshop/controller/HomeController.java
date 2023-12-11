package com.poly.website_norulesshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home/index"})
    public String index(Model model) {

        model.addAttribute("title", "Trang chủ");
        return "user/index";
    }
}
