package com.poly.website_norulesshop.controller.user;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.utils.FileUploadUtil;
import com.poly.website_norulesshop.utils.SessionService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("home")
public class MyAccountController {
    @Autowired
    SessionService session;
    @Autowired
    AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/user/img/avatar/";

    @GetMapping("/my-account")
    public String index(Model model) throws InterruptedException {
        return "user/my_account";
    }

}


