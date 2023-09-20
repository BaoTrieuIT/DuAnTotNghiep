package com.poly.website_norulesshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class ProductController {
    @RequestMapping("product_all")
    public static String product_all(){
        return "admin/product_all";
    }
    @RequestMapping("product_add")
    public static String product_add(){
        return "admin/product_add";
    }
    @RequestMapping("product_report")
    public static String product_report(){
        return "admin/product_report";
    }

}
