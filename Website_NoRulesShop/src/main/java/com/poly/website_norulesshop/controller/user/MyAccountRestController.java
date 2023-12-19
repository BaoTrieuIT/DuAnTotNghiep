package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.dto.ChangeAccountDTO;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.utils.FileUploadUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

import static com.poly.website_norulesshop.controller.user.MyAccountController.UPLOAD_DIRECTORY;

@RestController
@RequestMapping("/api/my-account/")
public class MyAccountRestController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountService accountService;


    @GetMapping("/checkPasswordMatch")
    public ResponseEntity<?> checkPasswordMacth(@RequestParam String currentPassword) {
        Map<String, Object> result = new HashMap<>();
        try {
            Account currentAccount = (Account) httpSession.getAttribute("acc");
            if (passwordEncoder.matches(currentPassword, currentAccount.getPassword())) {
                result.put("status", "success");
                result.put("result", true);
            } else {
                result.put("status", "not match");
                result.put("result", false);
            }
        } catch (Exception e) {
            result.put("status", "error");
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/changeAccountInfo")
    public ResponseEntity<?> changeAccoungInfo(@RequestParam("image") MultipartFile file,
                                               @RequestBody ChangeAccountDTO changeAccountDTO) {
        Map<String, Object> result = null;
        try {
            result = new HashMap<>();
            Account currentAccount = (Account) httpSession.getAttribute("acc");
            if (currentAccount != null) {
                currentAccount.setFullname(changeAccountDTO.getFullname());
                currentAccount.setPhone_number(changeAccountDTO.getPhonenumber());
                currentAccount.setBirthday(changeAccountDTO.getBirthday());
                currentAccount.setAddress(changeAccountDTO.getAddress());
                if (changeAccountDTO.getChangePassword()) {
                    currentAccount.setPassword(passwordEncoder.encode(changeAccountDTO.getNewPassword()));
                }
                try {
                    String originalFileName = file.getOriginalFilename();
                    FileUploadUtil.saveFile(UPLOAD_DIRECTORY, originalFileName, file);
                    currentAccount.setAvatar_url(originalFileName);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                result.put("status", "success");
                result.put("data", currentAccount);
                httpSession.setAttribute("acc", currentAccount);
                accountService.update(currentAccount);
            }
        } catch (Exception e) {
            result.put("status", "error");
            result.put("detail", e.toString());
        }
        return ResponseEntity.ok(result);
    }
}
