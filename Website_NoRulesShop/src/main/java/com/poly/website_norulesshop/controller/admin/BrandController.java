package com.poly.website_norulesshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class BrandController {
    @RequestMapping("manage_brand")
    public static String manage_brand(){
        return "admin/manage_brand";
    }
}
