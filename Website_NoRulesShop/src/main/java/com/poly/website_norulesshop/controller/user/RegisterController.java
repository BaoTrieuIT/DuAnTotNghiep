package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class RegisterController {
    @RequestMapping("sign-up")
    public String register_form(Model model) {
        Account acc = new Account();
        model.addAttribute("item", acc);

        return "user/sign_up";

    }

    @RequestMapping("sign-up/create")
    public String register_create(Model model, Account item) {
        System.out.println(item.getEmail());
        return "redirect:/home/sign-in";
    }


}
