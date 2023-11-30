package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class LogoutController {
    @Autowired
    SessionService service;

    @RequestMapping("sign-out")
    public String logout() {
        service.remove("acc");
        service.remove("authentication");
        return "user/sign_in";
    }
}
