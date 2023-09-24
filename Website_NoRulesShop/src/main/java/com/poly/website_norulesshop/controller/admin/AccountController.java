package com.poly.website_norulesshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AccountController {
    @RequestMapping("manage_account")
    public String manage_account(){
        return "admin/manage_account";
    }

    @RequestMapping("account_add")
    public String account_report(){
        return "admin/account_add";
    }
}
