package com.poly.website_norulesshop.controller.api;

import com.poly.website_norulesshop.entity.ContactUsForm;
import com.poly.website_norulesshop.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/contact-us")
public class APIContactUs {

    @Autowired
    EmailService emailService;

    @PostMapping("sendMailContactUs")
    public ResponseEntity<?> send(@RequestBody ContactUsForm contactUsForm){
        Map<String, Object> result= new HashMap<>();
        sendEmail(contactUsForm);
        return ResponseEntity.ok(result);
    }

    private void sendEmail(ContactUsForm contactUsForm) {
        String to = "tunghoang25073012@gmail.com";
//        String to = "canhdang341@gmail.com";
        emailService.sendEmailContactUs(to,contactUsForm.getEmail(),contactUsForm.getMessage(),contactUsForm.getSubject(),contactUsForm.getFirstname(),contactUsForm.getLastname());
    }
}

