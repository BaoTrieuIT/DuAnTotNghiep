package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.utils.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;


@Controller
@RequestMapping("home")
public class MyAccountController {
    @Autowired
    SessionService session;
    @Autowired
    AccountService accountService;

    @GetMapping("/my-account")
    public String index(Model model) throws InterruptedException {
        model.addAttribute("title", "Tài khoản của tôi");
        Account account = session.get("acc");
        String path = "/user/img/avatar/" + account.getAvatar_url();
        model.addAttribute("imagePath", path);
        model.addAttribute("acc", account);
        return "user/my_account";
    }

    @PostMapping("/my-account/update")
    public String update(@RequestParam("image") MultipartFile file,
                         @Valid @ModelAttribute Account acc, Model model,
                         BindingResult result,
                         @RequestParam("password") String newPassword,
                         @RequestParam("comfirmPassword") String comfirmPassword,
                         @RequestParam(value = "changePassword", required = false, defaultValue = "false") boolean changePassword,
                         Principal principal) {
        // Kiểm tra họ tên không để trống và không có kí tự đặc biệt hoặc số
        if (acc.getFullname() == null || !acc.getFullname().matches("^[a-zA-Z\\s]+$")) {
            result.rejectValue("fullname", "error.account", "Họ và tên không hợp lệ");
            return "user/my_account";
        }
        // Kiểm tra số điện thoại là số và có độ dài là 10
        if (acc.getPhone_number() == null || !acc.getPhone_number().matches("\\d{10}")) {
            result.rejectValue("phone_number", "error.user", "Số điện thoại không hợp lệ");
            return "user/my_account";
        }

        // Kiểm tra ngày sinh
        if (acc.getBirthday() != null) {
            LocalDate today = LocalDate.now();
            LocalDate birthday = acc.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long age = ChronoUnit.YEARS.between(birthday, today);
            if (age < 12 || age > 120) {
                result.rejectValue("birthday", "error.account", "Ngày sinh không đủ 12 tuổi hoặc lớn hơn 200 tuổi");
                return "user/my_account";
            }
        }

        // Kiểm tra mật khẩu nếu có sự thay đổi
        if (comfirmPassword != null && changePassword && acc.getPassword() != null && acc.getPassword().length() > 6) {
            if (!acc.getPassword().equals(comfirmPassword)) {
                result.rejectValue("password", "error.account", "Mật khẩu mới và xác nhận mật khẩu không khớp.");
                return "user/my_account";
            }
            acc.setPassword(newPassword);
        }
        // Xử lý ảnh
        try {
            String directoryPath = "src/main/resources/static/user/img/avatar/";
            Path fileNameAndPath = Paths.get(directoryPath, file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());

            // Lưu đường dẫn của ảnh vào cơ sở dữ liệu
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            acc.setAvatar_url(filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        // Cập nhật thông tin tài khoản
        accountService.updateAccount_frUser(acc);
        model.addAttribute("acc", acc);
        session.set("acc", acc);
        System.out.println(acc);
        System.out.println("ID: " + acc.getAccount_id());
        return "redirect:/home/my-account";
    }
}
//    @PostMapping("/my-account/update")
//    public String update(@RequestParam("image") MultipartFile file,
//                         @Valid @ModelAttribute Account acc, Model model,
//                         BindingResult result,
//                         @RequestParam("password") String newPassword,
//                         @RequestParam("comfirmPassword") String comfirmPassword,
//                         @RequestParam(value = "changePassword", required = false, defaultValue = "false") boolean changePassword,
//                         Principal principal) {
//        System.out.println("newPassword: " + newPassword);
//        System.out.println("comfirmPassword: " + comfirmPassword);
//
//        // Kiểm tra họ tên không để trống và không có kí tự đặc biệt hoặc số
//        if (acc.getFullname() == null || !acc.getFullname().matches("^[a-zA-Z\\s]+$")) {
//            result.rejectValue("fullname", "error.account", "Họ và tên không hợp lệ");
//            return "user/my_account";
//        }
//        // Kiểm tra ngày sinh
//        if (acc.getBirthday() != null) {
//            LocalDate today = LocalDate.now();
//            LocalDate birthday = acc.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            long age = ChronoUnit.YEARS.between(birthday, today);
//
//            if (age < 12 || age > 200) {
//                result.rejectValue("birthday", "error.account", "Ngày sinh không đủ 12 tuổi hoặc lớn hơn 200 tuổi");
//                return "user/my_account";
//            }
//        }
//
//        // Kiểm tra mật khẩu nếu có sự thay đổi
//        if (comfirmPassword != null && changePassword && newPassword != null && newPassword.length() > 6) {
//            if (!newPassword.equals(comfirmPassword)) {
//                model.addAttribute("errorDiv", "Mật khẩu mới và xác nhận mật khẩu không khớp.");
//                return "user/my_account";
//            }
//            acc.setPassword(newPassword);
//        }
//
//        // Xử lý ảnh
//        try {
//            String directoryPath = "src/main/resources/static/user/img/avatar/";
//            Path fileNameAndPath = Paths.get(directoryPath, file.getOriginalFilename());
//            Files.write(fileNameAndPath, file.getBytes());
//
//            // Lưu đường dẫn của ảnh vào cơ sở dữ liệu
//            String filename = StringUtils.cleanPath(file.getOriginalFilename());
//            acc.setAvatar_url(filename);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        // Cập nhật thông tin tài khoản
//        accountService.updateAccount_frUser(acc);
//        model.addAttribute("acc", acc);
//        session.set("acc", acc);
//        System.out.println(acc);
//        System.out.println("ID: " + acc.getAccount_id());
//        return "redirect:/home/my-account";
//    }
//}
