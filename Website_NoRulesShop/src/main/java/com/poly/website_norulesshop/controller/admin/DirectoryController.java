package com.poly.website_norulesshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class DirectoryController {
    @RequestMapping("manage_directory")
    public static String manage_directory(){
        return "admin/manage_directory";
    }
}
