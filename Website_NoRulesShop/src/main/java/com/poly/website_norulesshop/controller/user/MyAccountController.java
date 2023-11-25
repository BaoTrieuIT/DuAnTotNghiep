package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.entity.Address;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.service.AddressService;
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
import java.util.Optional;


@Controller
@RequestMapping("home")
public class MyAccountController {
    @Autowired
    SessionService session;
    @Autowired
    AccountService accountService;
    @Autowired
    AddressService addressService;

    @GetMapping("/my-account")
    public String index(Model model) throws InterruptedException {
        model.addAttribute("title", "Tài khoản của tôi");
        Account account = session.get("acc");
        String path = "/user/img/avatar/" + account.getAvatar_url();
        model.addAttribute("imagePath", path);
        model.addAttribute("acc", account);
//
//        String generalAddress = account.getAddress().getGeneralAddress();
//        System.out.println("D/c: " + generalAddress);
//
//        // Kiểm tra nếu generalAddress không phải là null trước khi sử dụng split
//        if (generalAddress != null) {
//            String[] addressParts = generalAddress.split(","); // Tách chuỗi dựa trên dấu phẩy
//
//            System.out.println("city: " + (addressParts.length > 2 ? addressParts[2].trim() : ""));
//            System.out.println("district: " + (addressParts.length > 1 ? addressParts[1].trim() : ""));
//            System.out.println("ward: " + (addressParts.length > 0 ? addressParts[0].trim() : ""));
//
//            // Truyền giá trị cho từng select box
//            model.addAttribute("city", addressParts.length > 2 ? addressParts[2].trim() : "");
//            model.addAttribute("district", addressParts.length > 1 ? addressParts[1].trim() : "");
//            model.addAttribute("ward", addressParts.length > 0 ? addressParts[0].trim() : "");
//        } else {
//            // Xử lý khi generalAddress là null
//            model.addAttribute("city", "Tỉnh/ Thành phố");
//            model.addAttribute("district",  "Quận/ Huyện");
//            model.addAttribute("ward",  "Phường/Thị trấn");
//        }

        return "user/my_account";
    }


    @PostMapping("/my-account/update")
    public String update(@RequestParam("image") MultipartFile file,
                         @Valid @ModelAttribute Account acc, Model model,
                         BindingResult result,
                         @RequestParam("password") String newPassword,
                         @RequestParam("comfirmPassword") String comfirmPassword,
                         @RequestParam("hiddenAddress") String address,
                         @RequestParam(value = "changePassword", required = false, defaultValue = "false") boolean changePassword,
                         Principal principal) {
        // Lấy thông tin tài khoản từ username của người đăng nhập
        String username = principal.getName();
        Account existingAccount = accountService.findByUsername(username);
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

        // Địa chỉ
        Optional<Address> existingAddress = addressService.getAddressByAccountId(acc);
        String cities = (String) model.getAttribute("city");
        System.out.println("general: "+cities);
//        String
        if (existingAddress.isPresent()) {
            Address ad = existingAddress.get();
            ad.setRecipientName(acc.getFullname());
            ad.setRecipientPhoneNumber(acc.getPhone_number());
            ad.setSpecificAddress(acc.address.getSpecificAddress());
            ad.setAccount(acc);
//            ad.setGeneralAddress(address);
            ad.setGeneralAddress(acc.address.getGeneralAddress());
            addressService.saveAddress(ad);
        } else {
            Address newAddress = new Address();
            newAddress.setRecipientName(acc.getFullname());
            newAddress.setRecipientPhoneNumber(acc.getPhone_number());
            newAddress.setSpecificAddress(acc.address.getSpecificAddress());
            newAddress.setAccount(acc);
            newAddress.setGeneralAddress(acc.address.getGeneralAddress());
            addressService.saveAddress(newAddress);
            System.out.println(newAddress);

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
//    @GetMapping("/my-account")
//    public String index(Model model) throws InterruptedException {
//        model.addAttribute("title", "Tài khoản của tôi");
//        Account account = session.get("acc");
//        String path = "/user/img/avatar/" + account.getAvatar_url();
//        model.addAttribute("imagePath", path);
//        model.addAttribute("acc", account);
//        String generalAddress = account.getAddress().getGeneralAddress();
//        System.out.println("D/c: "+generalAddress);
//        String[] addressParts = generalAddress.split(","); // Tách chuỗi dựa trên dấu phẩy
//
//        System.out.println("city: "+addressParts[2].trim());
//        System.out.println("district: "+addressParts[1].trim());
//        System.out.println("ward: "+ addressParts[0].trim());
//        // Truyền giá trị cho từng select box
//        model.addAttribute("city", addressParts[2].trim());
//        model.addAttribute("district", addressParts[1].trim());
//        model.addAttribute("ward", addressParts[0].trim());
//        return "user/my_account";
//    }
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
