package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.dto.AccountDTO;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.service.EmailService;
import com.poly.website_norulesshop.utils.SessionService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("home")
public class RegisterController {
    private final AccountService accountService;
    private final EmailService emailService;

    @Autowired
    SessionService sessionService;

    public RegisterController(AccountService accountService, EmailService emailService) {
        this.accountService = accountService;
        this.emailService = emailService;
    }

    @GetMapping("/sign-up")
    public String register_form(Model model) {
        AccountDTO accountDTO = new AccountDTO();
        model.addAttribute("item", accountDTO);
        model.addAttribute("title", "Đăng ký tài khoản");
        return "user/sign_up";

    }

    @PostMapping("/sign-up")
    public String register(@Valid @ModelAttribute("item") AccountDTO accountDTO, BindingResult result, Model model) {
        Account exitAccount = accountService.findByUsername(accountDTO.getUsername());
        Account exitEmail = accountService.findByEmail(accountDTO.getEmail());
        if (exitAccount != null) {
            result.rejectValue("username", "error.user",
                    "Tên tài khoản đã được đăng ký!");
            return "user/sign_up";
        }
        if (exitEmail != null) {
            result.rejectValue("email", "error.user",
                    "Email đã được đăng ký!");
            return "user/sign_up";
        }
        if (accountDTO.getPassword().length() < 6) {
            result.rejectValue("password", "error.user", "Mật khẩu phải có từ 6 ký tự trở lên !!!");
            return "user/sign_up";
        }

        if (!accountDTO.getPassword().equals(accountDTO.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "error.user", "Mật khẩu không trùng khớp!!!");
            return "user/sign_up";
        }

        model.addAttribute("item", accountDTO);
//        accountService.saveAccount(accountDTO);
        sessionService.set("account", accountDTO);
//        model.addAttribute("email", accountDTO.getEmail());
        emailService.sendCode(accountDTO.getEmail());
        return "redirect:/home/send-otp";
    }

    @GetMapping("/send-otp")
    public String send_otp(Model model) {
        AccountDTO accountDTO = sessionService.get("account");
        model.addAttribute("email", accountDTO.getEmail());
        model.addAttribute("title", "Xác thực OTP");
        return "user/otp_verification";
    }

    @PostMapping("/check-code")
    public String check_code(Model model, @ModelAttribute("fullCode") String code) {
        String generatorCode = sessionService.get("generatorCode");
        if (!generatorCode.equals(code)) {
            return "redirect:/home/send-otp?error";
        }
        try {
            AccountDTO accountDTO = sessionService.get("account");
            accountService.saveAccount(accountDTO);
            sessionService.remove("account");
            sessionService.remove("generatorCode");
            return "redirect:/home/sign-in";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/home/403Page";
        }

    }

    @GetMapping("/update-email")
    public String update_email(Model model) {
        AccountDTO accountDTO = sessionService.get("account");
        model.addAttribute("item", accountDTO);
        model.addAttribute("title", "Đăng ký tài khoản");
        return "user/sign_up";
    }

//    @GetMapping("/sign-up/create")
//    public String create(Model model, Account item) {
//        return "redirect:/home/sign-in";
//    }
}
