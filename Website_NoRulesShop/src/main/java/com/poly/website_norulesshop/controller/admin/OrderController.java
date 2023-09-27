package com.poly.website_norulesshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class OrderController {
    @RequestMapping("order_all")
    public static String order_all(){
        return "admin/order_all";
    }
    @RequestMapping("order_cancel")
    public static String order_cancel(){
        return "admin/order_cancel";
    }
    @RequestMapping("order_back")
    public static String order_back(){
        return "admin/order_back";
    }

}