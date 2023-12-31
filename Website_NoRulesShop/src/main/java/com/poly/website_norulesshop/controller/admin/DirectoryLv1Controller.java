package com.poly.website_norulesshop.controller.admin;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poly.website_norulesshop.config.ResponseMessage;
import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.DirectoryLv1;
import com.poly.website_norulesshop.service.DirectoryLv1Service;
import com.poly.website_norulesshop.service.DirectoryService;

@CrossOrigin("*")
@RestController
 @RequestMapping("/rest/manage_directoryLv1")
// @RequestMapping("/rest/directoryLv1")
public class DirectoryLv1Controller {
    @Autowired
    DirectoryService directoryService;
    @Autowired
    DirectoryLv1Service directoryLv1Service;

    @GetMapping
    public List<DirectoryLv1> getListDirectoryLv1List(){
        return directoryLv1Service.getAllDirectoryLv1s();
    }

    @GetMapping("isActive")
    public List<DirectoryLv1> getListDirectoryLv1ListIsActive(){
        return directoryLv1Service.getByIsActive(true);
    }

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
    public ResponseEntity<Object> deleteDirectories(@RequestBody List<Integer> directoryIds) {
        try {
            directoryLv1Service.deleteDirectories(directoryIds);
            return ResponseEntity.ok(new ResponseMessage("Deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Failed to delete directories"));
        }
    }



    @GetMapping("/changeIsActive/{id}")
    public ResponseEntity<?> changeIsActive(@PathVariable Integer id, @RequestParam Boolean isActive){
        Map<String, Object> result = new HashMap<>();
        try {
            DirectoryLv1 directoryLv1 = directoryLv1Service.getDirectoryLv1ById(id);
            if(directoryLv1 != null){
                directoryLv1.setIsActive(isActive);
                DirectoryLv1 updatedDirectoryLv1 =  directoryLv1Service.saveDirectoryLv1(directoryLv1);
                result.put("status","success");
                result.put("data",updatedDirectoryLv1);
            }else{
                result.put("status","failed");
                result.put("detail","not found dirtory lv1 with this id = " + id);
            }
        }catch (Exception e){
            result.put("status","error");
            result.put("detail",e.toString());
        }
        return ResponseEntity.ok(result);
    }



}
