package com.poly.website_norulesshop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class LogoutController {
    @RequestMapping("sign-out")
    public String logout(){
        return "user/sign_in";
    }


}
