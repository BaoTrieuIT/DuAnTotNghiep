package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.model.Brand;
import com.poly.website_norulesshop.model.Directory;
import com.poly.website_norulesshop.model.DirectoryLv1;
import com.poly.website_norulesshop.model.Gender;
import com.poly.website_norulesshop.service.DirectoryLv1Service;
import com.poly.website_norulesshop.service.DirectoryService;
import com.poly.website_norulesshop.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/manage_directory")
public class DirectoryController {
//    @Autowired
//    DirectoryLv1Service directoryLv1Service;
//    @GetMapping
//    public List<DirectoryLv1> getAll() {
//        return directoryLv1Service.getAllDirectoryLv1s();
//    }

    @Autowired
    GenderService genderService;
    @Autowired
    DirectoryService directoryService;
    @GetMapping
    public List<Directory> getAllD() {
        return directoryService.getAllDirectories();
    }


    @GetMapping("/getByGender")
    public List<Directory> findByGender(@RequestParam String genderId ){
        Gender genderSelected  = genderService.getGenderById(Integer.parseInt(genderId));
        return directoryService.getByGender(genderSelected);
    }
}
