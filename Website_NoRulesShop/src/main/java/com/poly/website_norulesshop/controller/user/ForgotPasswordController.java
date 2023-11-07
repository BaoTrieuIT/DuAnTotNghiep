package com.poly.website_norulesshop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class ForgotPasswordController {

    @RequestMapping("forgot-password")
    public String index(Model model) {
        model.addAttribute("title", "Quên mật khẩu");
        return "user/forgot_password";
    }
}
