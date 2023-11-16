package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.dto.AccountDTO;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.utils.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import static java.time.ZoneId.getAvailableZoneIds;
import static java.time.ZoneId.systemDefault;

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

    //    @PostMapping("/my-account/update")
//    public String update(@Valid @ModelAttribute Account acc, Model model,
//                         @RequestParam("password") String newPassword,
//                         @RequestParam("comfirmPassword") String comfirmPassword){
//        System.out.println("newPassword: "+newPassword);
//        System.out.println("comfirmPassword: "+comfirmPassword);
//        if(newPassword !=null && newPassword.length() >6){
//            if(newPassword.equals(comfirmPassword)){
//                acc.setPassword(newPassword);
//                System.out.println(acc.getPassword());
//                accountService.updateAccount_frUser(acc);
//                model.addAttribute("acc", acc);
//                session.set("acc",acc);
//                System.out.println(acc);
//                return "redirect:/home/my-account";
//            }else{
//                return "user/forgot_password";
//            }
//        }else{
//            model.addAttribute("errorDiv","Mật khẩu mới không để trống và phải có ít nhất 6 ký tự.");
//        }
//        return "redirect:/home/my-account";
//    }

    @PostMapping("/my-account/update")
    public String update(@Valid @ModelAttribute Account acc, Model model,
                         BindingResult result,
                         @RequestParam("password") String newPassword,
                         @RequestParam("comfirmPassword") String comfirmPassword,
                         @RequestParam(value = "changePassword", required = false, defaultValue = "false") boolean changePassword,
                         Principal principal) {
        System.out.println("newPassword: " + newPassword);
        System.out.println("comfirmPassword: " + comfirmPassword);
        // Kiểm tra họ tên không để trống và không có kí tự đặc biệt hoặc số
        if (acc.getFullname() == null || !acc.getFullname().matches("^[a-zA-Z\\s]+$")) {
            result.rejectValue("fullname", "error.account", "Họ và tên không hợp lệ");
            return "user/my_account";
        }
//        if(ChronoUnit.YEARS.between(acc.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),LocalDate.now())<=12){
//            result.rejectValue("birthday","error.account","Ngày sinh không hợp lệ");
//            return "user/my_account";
//        }

        if (comfirmPassword != null && changePassword && newPassword != null && newPassword.length() > 6) {
            if (newPassword.equals(comfirmPassword)) {
                acc.setPassword(newPassword);
                System.out.println(acc.getPassword());
                accountService.updateAccount_frUser(acc);
                model.addAttribute("acc", acc);
                session.set("acc", acc);
                System.out.println(acc);
                System.out.println("ID: " + acc.getAccount_id());
                return "redirect:/home/my-account";
            } else {
                model.addAttribute("errorDiv", "Mật khẩu mới và xác nhận mật khẩu không khớp.");
            }
        } else {
            // Người dùng không chọn checkbox, giữ nguyên mật khẩu cũ
            acc.setPassword(acc.getPassword());
            accountService.updateAccount_frUser(acc);
            model.addAttribute("acc", acc);
            session.set("acc", acc);
            System.out.println(acc);
            System.out.println("ID: " + acc.getAccount_id());
            return "redirect:/home/my-account";
        }

        return "user/forgot_password";
    }


}
