package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.constant.EmailType;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.service.EmailService;
import com.poly.website_norulesshop.utils.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    SessionService sessionService;
    private static final String EMAIL_WELCOME_SUBJECT = "WELCOME TO NORULES SHOP";

    private static final String EMAIL_SEND_CODE = "NORULES SHOP - YOUR CODE";

    private static final String EMAIL_SEND_CONTACT_US = "NORULES SHOP - CUSTOMER CONTACT INFORMATION";


    AccountService accountService;
    private final JavaMailSender mailSender;

    public EmailServiceImpl(AccountService accountService, JavaMailSender mailSender) {
        this.accountService = accountService;
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String content, String subject, String code, EmailType emailType) {
        SimpleMailMessage message = new SimpleMailMessage();
//        String content = null;
//        String subject = null;
        switch (emailType) {
            case WELCOME_TO_WEBSITE:
                subject = EMAIL_WELCOME_SUBJECT;
                content = "Love You!!!";
                break;
            case EMAIL_SEND_CODE:
                subject = EMAIL_SEND_CODE;
                content = "Your Code Here : " + code;
                break;
            case CONTACT_US:
                subject = EMAIL_SEND_CONTACT_US;
                content = content;
                break;
            default:
                subject = "NORULES SHOP";
                content = "Email Wrong";
        }
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        mailSender.send(message);
    }

    public void sendEmailContactUs(String to, String email, String content, String subject, String firstName, String lastName) {
        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText("First Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email + "\n\n" + content);
        content = "First Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email + "\n\n" + "Message : " + content;
        sendEmail(to, content, subject, null, EmailType.CONTACT_US);
//        mailSender.send(message);
    }

    @Override
    public void sendCode(String email) {
//        Optional.ofNullable(accountService.findByEmail(email))
//                .map(account -> {
        String code = generateCode();
        sendEmail(email, null, null, code, EmailType.EMAIL_SEND_CODE);
        System.out.println(code);
        sessionService.set("generatorCode", code);
//                    return codeAccMap.put(code, account);
//                });
    }

    @Override
    public String generateCode() {
        return String.valueOf((int) (Math.random() * 900000) + 100000);
    }

//    @Override
//    public String getCode() {
//        return sendCode().get();
//    }
}
