package com.poly.website_norulesshop.controller.api;

import com.poly.website_norulesshop.constant.EmailType;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.service.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("api/forgot-password")
public class ForgotPasswordAPI {


    @Autowired
    EmailService emailService;


    @Autowired
    AccountService accountService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/sendOTP/{email}")
    public ResponseEntity<?> sendOTP(@PathVariable("email") String email){
        Map<String, Object> result = new HashMap<>();
//            send OTP here
        try{
            String OTP  = generateOTP();
            Account account =  accountService.findByEmail(email);
            if(account != null){
                result.put("status","Success");
                result.put("OTP",OTP);
                result.put("account", account);
                emailService.sendEmail(email, OTP, EmailType.EMAIL_SEND_CODE);
            }else{
                result.put("status","Failed");
                result.put("detail","Not Found Account");
            }
        }catch (Exception e){
            result.put("status", "error");
            result.put("detail", e);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestParam String newPassword, @RequestParam("email") String email){
        Map<String, Object> result = new HashMap<>();
//            send OTP here
        try{
            Account existAccount =  accountService.resetPassword(email, newPassword);
            if(existAccount != null){
                result.put("status","Success");
            }else{
                result.put("status","Failed");
                result.put("detail","Not Found Account");
            }
        }catch (Exception e){
            result.put("status", "Error");
            result.put("detail", e);
        }
        return ResponseEntity.ok(result);
    }

    public static String generateOTP() {
        String digits = "0123456789";
        int otpLength = 6;
        Random random = new Random();
        StringBuilder otp = new StringBuilder(otpLength);

        for (int i = 0; i < otpLength; i++) {
            int index = random.nextInt(digits.length());
            otp.append(digits.charAt(index));
        }
        return otp.toString();
    }
}
