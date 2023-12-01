package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.constant.EmailType;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmail(String to, String code, EmailType emailType);
    void sendEmailContactUs(String to,String email, String content,String subject, String firstName, String lastName);
    void sendCode(String email);


    String generateCode();
//
//    String getCode(String code);
}
