package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    SessionService session;

    @RequestMapping("index")
    public String index(Model model) {
        Account acc = session.get("acc");
        return "redirect:/admin/layout.html";
    }
}
