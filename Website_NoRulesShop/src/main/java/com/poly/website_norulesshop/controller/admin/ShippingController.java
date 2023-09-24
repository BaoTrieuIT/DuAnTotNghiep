package com.poly.website_norulesshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class ShippingController {
    @RequestMapping("manage_shipping")
    public static String product_all(){
        return "admin/manage_shipping";
    }
    @RequestMapping("setting_shipping")
    public static String product_add(){
        return "admin/setting_shipping";
    }

}
