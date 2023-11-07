package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.test.FindAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class AboutUsController {

    //    @Autowired
//    FindAllService findAllService;
    @RequestMapping("about-us")
    public String index(Model model) {
        model.addAttribute("title", "Giới thiệu về chúng tôi");

        return "user/about_us";

    }
}
