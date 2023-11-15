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
                         @RequestParam(value = "changePassword", required = false,defaultValue = "false") boolean changePassword,
                         Principal principal) {
        System.out.println("newPassword: " + newPassword);
        System.out.println("comfirmPassword: " + comfirmPassword);
        if(result.hasErrors()){
            model.addAttribute("errorDiv", "Có lỗi xảy ra. Vui lòng kiểm tra lại thông tin của bạn.");
            return "user/my_account";
        }
        if (comfirmPassword != null && changePassword && newPassword != null && newPassword.length() > 6) {
            if (newPassword.equals(comfirmPassword)) {
                acc.setPassword(newPassword);
                System.out.println(acc.getPassword());
                accountService.updateAccount_frUser(acc);
                model.addAttribute("acc", acc);
                session.set("acc", acc);
                System.out.println(acc);
                System.out.println("ID: "+acc.getAccount_id());
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
            System.out.println("ID: "+acc.getAccount_id());
            return "redirect:/home/my-account";
        }

        return "user/forgot_password";
    }


}
