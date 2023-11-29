package com.poly.website_norulesshop.controller.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("home")
public class LoginController {
    @GetMapping("sign-in")
    public String login_form(Model model) {
        model.addAttribute("title", "Đăng nhập");
        return "user/sign_in";

    }

    @RequestMapping("sign-in/error")
    public String login_error() {
        return "user/sign_in";
    }


}
