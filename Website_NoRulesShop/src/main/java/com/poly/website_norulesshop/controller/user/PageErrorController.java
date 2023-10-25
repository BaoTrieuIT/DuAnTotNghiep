package com.poly.website_norulesshop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class PageErrorController {
   @RequestMapping("403Page")
    public String login_form() {
//
       return "user/403";

    }



}
