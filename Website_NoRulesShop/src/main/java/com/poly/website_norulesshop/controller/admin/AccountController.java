package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.*;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.service.AccountStatusService;
import com.poly.website_norulesshop.service.RoleService;
import com.poly.website_norulesshop.utils.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/manage_account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    AccountStatusService accountStatusService;

    @Autowired
    RoleService roleService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/getAccountInfo")
    public Account getAccountInfo() {
        Account account = sessionService.get("acc");
        return account;
    }
            @PostMapping("/upload")
            public ResponseEntity<String> uploadImage(@RequestParam("fileName") MultipartFile file) {
                try {
                    if (file != null && !file.isEmpty()) {
                        String directoryPath1 = "src/main/resources/static/admin/imagesAccount/";
                        Path path1 = Paths.get(directoryPath1);

                        if (!Files.exists(path1)) {
                            Files.createDirectories(path1);
                        }
                        String fileName1 = file.getOriginalFilename();
                        Path filePath1 = Paths.get(directoryPath1, fileName1);
                        Files.write(filePath1, file.getBytes());

                        String directoryPath2 = "src/main/resources/static/user/img/avatar/";
                        String fileName2 = file.getOriginalFilename();
                        Path filePath2 = Paths.get(directoryPath2, fileName2);
                        Files.write(filePath2, file.getBytes());

                        // Get the user's home directory
                        String userHome = System.getProperty("user.home");
                        String directoryPath = userHome + File.separator + "imagesAccount/";
                        Path path = Paths.get(directoryPath);

                        if (!Files.exists(path)) {
                            Files.createDirectories(path);
                        }
                        String fileName = file.getOriginalFilename() ;
                        Path filePath = Paths.get(directoryPath, fileName);
                        Files.write(filePath, file.getBytes());

                        String imagePath = fileName;
                        Account account1 = new Account();
                        account1.setAvatar_url(imagePath);
                        return ResponseEntity.ok("{\"message\": \"Tải ảnh lên thành công.\", \"imagePath\": \"" + imagePath + "\"}");
                    }else {
                        return ResponseEntity.ok("{\"message\": \"Không có file ảnh mới được cung cấp.\"}");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi tải ảnh lên.");
                }
            }
    @GetMapping("/image/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) throws MalformedURLException {
        String userHome = System.getProperty("user.home");
        Resource resource = new UrlResource("file:" +  userHome + File.separator + "imagesAccount/" + fileName);

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<Account> getAll(){
        Role role = roleService.getRoleById(1);
        Role role1 = roleService.getRoleById(2);
        role.setRole_name("Admin");
        role1.setRole_name("User");
        roleService.saveRole(role);
        roleService.saveRole(role1);
        return  accountService.getAllAccounts();
    }
    @PutMapping("{account_id}")
    public Account put(@PathVariable("account_id") Integer id, @RequestBody Account account) {
        Account account1 = accountService.getAccountById(id);
        Ranked ranked1 = account1.getRanked();
        account.setRanked(ranked1);
        return accountService.update(account);
    }


    @PutMapping("hidden/{account_id}")
    public Account Hidden(@PathVariable("account_id") Integer id,@RequestBody Account account){
        Account account1 = accountService.getAccountById(id);
        Set<Role> roles = account1.getRoles();
        Ranked ranked = account1.getRanked();
        AccountStatus accountStatus = accountStatusService.getAccountStatusById(3);
        account.setRanked(ranked);
        account.setRoles(roles);
        account.setAccountStatus(accountStatus);
        return  accountService.update(account);
    }
    @PutMapping("show/{account_id}")
    public Account Show(@PathVariable("account_id") Integer id,@RequestBody Account account){
        Account account1 = accountService.getAccountById(id);
        Set<Role> roles = account1.getRoles();
        Ranked ranked = account1.getRanked();
        AccountStatus accountStatus = accountStatusService.getAccountStatusById(1);
        account.setRanked(ranked);
        account.setRoles(roles);
        account.setAccountStatus(accountStatus);
        return  accountService.update(account);
    }
    @PutMapping("report/{account_id}")
    public Account Report(@PathVariable("account_id") Integer id,@RequestBody Account account){
        Account account1 = accountService.getAccountById(id);
        Set<Role> roles = account1.getRoles();
        Ranked ranked = account1.getRanked();
        AccountStatus accountStatus = accountStatusService.getAccountStatusById(1);
        account.setRanked(ranked);
        account.setRoles(roles);
        account.setAccountStatus(accountStatus);
        return  accountService.update(account);
    }


}