package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.DirectoryLv1;
import com.poly.website_norulesshop.service.DirectoryLv1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/manage_directory")
public class DirectoryController {
    @Autowired
    DirectoryLv1Service directoryLv1Service;
    @GetMapping
    public List<DirectoryLv1> getAll() {
        return directoryLv1Service.getAllDirectoryLv1s();
    }
}
