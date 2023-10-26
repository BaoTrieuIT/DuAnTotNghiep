package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.model.Account;
import com.poly.website_norulesshop.utils.SessionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class MyAccountController {
    @Autowired
    SessionService session;

    @RequestMapping("my-account")
    public String index(Model model) throws InterruptedException {
        Account acc = session.get("acc");
        String path = "/user/img/avatar/" + acc.getAvatar_url();
        model.addAttribute("imagePath", path);
        model.addAttribute("acc", acc);
        return "user/my_account";
    }
}
