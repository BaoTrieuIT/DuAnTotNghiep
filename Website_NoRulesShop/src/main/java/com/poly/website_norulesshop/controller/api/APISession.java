package com.poly.website_norulesshop.controller.api;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/session")
@RestController
public class ApiSession {
    @Autowired
    HttpSession httpSession;

    @GetMapping
    public Object get(@RequestParam String name){
        return httpSession.getAttribute(name);
    }

    @PostMapping
    public void set(@RequestParam String name, @RequestParam Object value){
        httpSession.setAttribute(name,value);
    }
}
