package com.poly.website_norulesshop.controller.admin;

import java.util.List;

import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poly.website_norulesshop.entity.DirectoryLv1;
import com.poly.website_norulesshop.service.DirectoryLv1Service;
import com.poly.website_norulesshop.service.DirectoryService;
import com.poly.website_norulesshop.service.GenderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/manage_directory")
public class DirectoryController {

    @Autowired
    GenderService genderService;
    @Autowired
    DirectoryService directoryService;
    @Autowired
    DirectoryLv1Service directoryLv1Service;

    @GetMapping
    public List<Directory> getAllD() {
        return directoryService.getAllDirectories();
    }


    @GetMapping("/Gender")
    public List<Directory> findByGender(@RequestParam String genderId) {
        Gender genderSelected = genderService.getGenderById(Integer.parseInt(genderId));
        return directoryService.getByGender(genderSelected);
    }

    @GetMapping("/DirectoryLv1")
    public List<DirectoryLv1> getAllDlv1() {
        return directoryLv1Service.getAllDirectoryLv1s();
    }

    @GetMapping("/Directory")
    public List<DirectoryLv1> loadDirectoryLv1(@RequestParam String directoryId) {
        Directory diId = directoryService.getDirectoryById(Integer.parseInt(directoryId));
        return directoryLv1Service.getByDirectory(diId);
    }

    @PostMapping("{id}")
    public Directory create(@RequestBody Directory directory, @PathVariable("id") String id) {
        Gender gender = genderService.getGenderById(Integer.parseInt(id));
        directory.setGender(gender);
        directoryService.saveDirectory(directory);
        return directory;
    }


}
