package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.utils.FileUploadUtil;
import com.poly.website_norulesshop.utils.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
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
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/user/img/avatar/";

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
                         Principal principal) throws IOException {
        // Lấy thông tin tài khoản từ username của người đăng nhập
        String username = principal.getName();
        Account existingAccount = accountService.findByUsername(username);
        // Kiểm tra họ tên không để trống và không có kí tự đặc biệt hoặc số
        if (acc.getFullname() == null ||  acc.getFullname().trim().isEmpty() || !acc.getFullname().matches("^[a-zA-Z\\s]+$")) {
            result.rejectValue("fullname", "error.account", "Họ và tên không hợp lệ");
            return "user/my_account";
        }
        // Kiểm tra email
        if (acc.getEmail() == null || !acc.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$")) {
            result.rejectValue("email", "error.account", "Email không hợp lệ");
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


        try {
            String originalFileName = file.getOriginalFilename();
            FileUploadUtil.saveFile(UPLOAD_DIRECTORY, originalFileName, file);
            acc.setAvatar_url(originalFileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


//        // Xử lý ảnh
//        try {
//            String directoryPath = "src/main/resources/static/user/img/avatar/";
//
//            // Lấy thông tin từ tên file gốc
//            String originalFileName = file.getOriginalFilename();
//            String[] fileNameParts = originalFileName.split("\\.");
//
//// Lấy tên file và đuôi file từ mảng fileNameParts
//            String fileName = fileNameParts[0]; // Tên file (trước dấu chấm)
//            String fileExtension = "png"; // Đặt đuôi file mới
//
//// Tạo tên file mới
//            String newFileName = "avatar_" + acc.getAccount_id() + "_" + fileName + "." + fileExtension;
//
//// Lưu ảnh và đường dẫn vào cơ sở dữ liệu
//            if (!originalFileName.toLowerCase().endsWith(".png")) {
//                BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                ImageIO.write(bufferedImage, fileExtension, byteArrayOutputStream);
//                Files.write(Paths.get(directoryPath, newFileName), byteArrayOutputStream.toByteArray());
//            } else {
//                Files.write(Paths.get(directoryPath, newFileName), file.getBytes());
//            }
//
//// Lưu đường dẫn ảnh vào thuộc tính avatar_url
//            String filename = StringUtils.cleanPath(newFileName);
//            acc.setAvatar_url(filename);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println("Pass nè: "+acc.getPassword());
        // Cập nhật thông tin tài khoản
//        acc.setPassword(passwordEncoder.encode());
        accountService.updateAccount_frUser(acc);
        model.addAttribute("acc", acc);
        session.set("acc", acc);
        return "redirect:/home/my-account";
    }
}
