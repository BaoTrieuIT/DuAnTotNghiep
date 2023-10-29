package com.poly.website_norulesshop.controller.admin;


import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.DirectoryLv1;
import com.poly.website_norulesshop.service.DirectoryLv1Service;
import com.poly.website_norulesshop.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("{id}")
    public DirectoryLv1 post(@RequestBody DirectoryLv1 lv1,@PathVariable("id") String id) {
        Directory directory = directoryService.getDirectoryById(Integer.parseInt(id));
        lv1.setDirectory(directory);
        directoryLv1Service.saveDirectoryLv1(lv1);
        return lv1;
    }

    @PutMapping("/update/{drlv1_id}")
    public DirectoryLv1 put(@PathVariable("drlv1_id") Integer id, @RequestBody DirectoryLv1 lv1) {
        return directoryLv1Service.saveDirectoryLv1(lv1);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDirectories(@RequestBody List<Integer> directoryIds) {
        try {
            directoryLv1Service.deleteDirectories(directoryIds);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete directories");
        }
    }


}
