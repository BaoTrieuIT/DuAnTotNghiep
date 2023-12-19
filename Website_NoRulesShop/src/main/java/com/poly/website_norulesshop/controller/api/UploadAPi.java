package com.poly.website_norulesshop.controller.api;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.service.FileUploadService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/uploadFile")
public class UploadAPi {

    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    HttpSession httpSession;


    @PostMapping("/saveAvatar")
    public Object saveFile (@RequestPart("file") MultipartFile file){
        try {
            Account account =(Account) httpSession.getAttribute("acc");
            String uploadDir = "src\\main\\resources\\static\\user\\img\\avatar";
            fileUploadService.saveFileByPathAndByName(account.getAvatar_url(),file, uploadDir);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
