package com.poly.website_norulesshop.controller.admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping("index")
    public String index (){
        return "admin/index";
    }
}
