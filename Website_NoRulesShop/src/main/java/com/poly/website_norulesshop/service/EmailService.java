package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.constant.EmailType;

public interface EmailService {
    void sendEmail(String to, String code, EmailType emailType);

    void sendCode(String email);


    String generateCode();
//
//    String getCode(String code);
}
