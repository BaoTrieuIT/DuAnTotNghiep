package com.poly.website_norulesshop.controller.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/login")
public class ApiLoginController {
    @ResponseBody
    @RequestMapping("authentication")
    public Object getAuthentication(HttpSession session) {

        return session.getAttribute("authentication");

    }


}
