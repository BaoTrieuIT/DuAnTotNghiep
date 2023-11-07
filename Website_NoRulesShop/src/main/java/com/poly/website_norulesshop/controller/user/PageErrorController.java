package com.poly.website_norulesshop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class PageErrorController {
    @RequestMapping("403Page")
    public String login_form(Model model) {
        model.addAttribute("title", "403 Error");
        return "user/403";

    }


}
