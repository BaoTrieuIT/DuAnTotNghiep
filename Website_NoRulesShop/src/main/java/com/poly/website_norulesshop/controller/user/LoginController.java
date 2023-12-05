package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.config.GlobalFlag;
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
        if (GlobalFlag.flag) {
            model.addAttribute("status", true);
        } else {
            model.addAttribute("status", false);
        }
        model.addAttribute("title", "Đăng nhập");
        return "user/sign_in";

    }
}
