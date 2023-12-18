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
//        model.addAttribute("title", "Tài khoản của tôi");
//        Account account = session.get("acc");
//        String path = "/user/img/avatar/" + account.getAvatar_url();
//        model.addAttribute("imagePath", path);
//        model.addAttribute("acc", account);
        return "user/my_account";
    }


//    @PostMapping("/my-account/update")
//    public String update(@RequestParam("image") MultipartFile file,
//                         @Valid @ModelAttribute Account acc,
//                         Model model,
//                         BindingResult result,
//                         @RequestParam("oldPassword") String oldPassword,
//                         @RequestParam("newPassword") String newPassword,
//                         @RequestParam("comfirmPassword") String comfirmPassword,
//                         @RequestParam(value = "changePassword", required = false, defaultValue = "false") boolean changePassword,
//                         Principal principal) throws IOException {
//        if (acc.getFullname() == null || !acc.getFullname().matches("^[a-zA-Z\\s]+$") || acc.getFullname().trim().isEmpty()) {
//            result.rejectValue("fullname", "error.account", "Họ và tên không hợp lệ");
//            return "user/my_account";
//        }
//        // Kiểm tra email
//        if (acc.getEmail() == null || !acc.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$")) {
//            result.rejectValue("email", "error.account", "Email không hợp lệ");
//            return "user/my_account";
//        }
//        // Kiểm tra số điện thoại là số và có độ dài là 10
//        if (acc.getPhone_number() == null || !acc.getPhone_number().matches("\\d{10}")) {
//            result.rejectValue("phone_number", "error.user", "Số điện thoại không hợp lệ");
//            return "user/my_account";
//        }
//        // Kiểm tra ngày sinh
//        if (acc.getBirthday() != null) {
//            LocalDate today = LocalDate.now();
//            LocalDate birthday = acc.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            long age = ChronoUnit.YEARS.between(birthday, today);
//            if (age < 12 || age > 120) {
//                result.rejectValue("birthday", "error.account", "Ngày sinh không đủ 12 tuổi hoặc lớn hơn 200 tuổi");
//                return "user/my_account";
//            }
//        }
//        // Kiểm tra mật khẩu nếu có sự thay đổi
//        if (changePassword) {
//            if (!accountService.checkPassword(principal.getName(), oldPassword)) {
//                result.rejectValue("oldPassword", "error.account", "Mật khẩu hiện tại không đúng");
//                return "user/my_account";
//            }
//            if (!newPassword.equals(comfirmPassword)) {
//                result.rejectValue("password", "error.account", "Mật khẩu mới và xác nhận mật khẩu không khớp.");
//                return "user/my_account";
//            }
//            acc.setPassword(newPassword);
//            System.out.println("Change");
//        } else {
//            acc.setPassword(oldPassword);
//            System.out.println("!Change");
//        }
//
//        try {
//            String originalFileName = file.getOriginalFilename();
//            FileUploadUtil.saveFile(UPLOAD_DIRECTORY, originalFileName, file);
//            acc.setAvatar_url(originalFileName);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        // Cập nhật thông tin tài khoản
//        Account account = session.get("acc");
//        account.setFullname(acc.getFullname());
//        account.setPhone_number(acc.getPhone_number());
//        account.setBirthday(acc.getBirthday());
//        account.setAddress(acc.getAddress());
//
//        if(changePassword){
//            if(passwordEncoder.encode(oldPassword).equals(acc.getPassword())){
//                account.setPassword(passwordEncoder.encode(newPassword));
//            }else{
//                result.rejectValue("oldPassword", "error.oldPassword", "Ngày sinh không đủ 12 tuổi hoặc lớn hơn 200 tuổi");
//            }
//        }
//        Account updateAccount = accountService.saveAccount(account);
//        session.set("acc",updateAccount);
//        return "redirect:/";
//    }
}

//        accountService.updateAccount_frUser(acc, newPassword);

