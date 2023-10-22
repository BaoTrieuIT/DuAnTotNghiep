package com.poly.website_norulesshop.controller.admin;


import com.poly.website_norulesshop.model.Brand;
import com.poly.website_norulesshop.model.Directory;
import com.poly.website_norulesshop.model.DirectoryLv1;
import com.poly.website_norulesshop.service.DirectoryLv1Service;
import com.poly.website_norulesshop.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/directoryLv1")
public class DirectoryLv1Controller {
    @Autowired
    DirectoryService directoryService;
    @Autowired
    DirectoryLv1Service directoryLv1Service;

//    @PostMapping
//    public DirectoryLv1 post(@RequestBody DirectoryLv1 lv1) {
//        directoryLv1Service.saveDirectoryLv1(lv1);
//        return lv1;
//    }
//    @PutMapping("{drlv1_id}")
//    public DirectoryLv1 put(@PathVariable("drlv1_id") Integer id, @RequestBody DirectoryLv1 lv1) {
//        return directoryLv1Service.saveDirectoryLv1(lv1);
//    }
//    @DeleteMapping("{drlv1_id}")
//    public void delete(@PathVariable("drlv1_id") Integer id) {
//         directoryLv1Service.deleteDirectoryLv1(id);
//    }

}
