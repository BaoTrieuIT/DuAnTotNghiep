package com.poly.website_norulesshop.controller.api;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/session")
public class APISession {
    @Autowired
    HttpSession httpSession;

    @GetMapping("/{sessionName}")
    public Object getSessionAttribute(@PathVariable String sessionName){
        return httpSession.getAttribute(sessionName);
    }
}
