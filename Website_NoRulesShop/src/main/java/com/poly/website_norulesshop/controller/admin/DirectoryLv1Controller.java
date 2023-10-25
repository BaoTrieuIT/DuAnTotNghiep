package com.poly.website_norulesshop.controller.admin;


import com.poly.website_norulesshop.model.Brand;
import com.poly.website_norulesshop.model.Directory;
import com.poly.website_norulesshop.model.DirectoryLv1;
import com.poly.website_norulesshop.model.Gender;
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

    @PostMapping("{id}")
    public DirectoryLv1 post(@RequestBody DirectoryLv1 lv1,@PathVariable("id") String id) {
        Directory directory = directoryService.getDirectoryById(Integer.parseInt(id));
        lv1.setDirectory(directory);
        directoryLv1Service.saveDirectoryLv1(lv1);
        return lv1;
    }
//    @PutMapping("/update/{drlv1_id}")
//    public DirectoryLv1 put(@PathVariable("drlv1_id") Integer id, @RequestBody DirectoryLv1 lv1) {
//        return directoryLv1Service.saveDirectoryLv1(lv1);
//    }

//    @DeleteMapping("{drlv1_id}")
//    public void delete(@PathVariable("drlv1_id") Integer id) {
//         directoryLv1Service.deleteDirectoryLv1(id);
//    }
//    @DeleteMapping("/directories/delete")
//    public ResponseEntity<String> deleteSelectedDirectories(@RequestBody List<Directory> selectedDirectories) {
//        // Thực hiện xóa các mục đã đánh dấu ở đây
//        // selectedDirectories chứa danh sách các mục đã đánh dấu
//        // Thực hiện xóa các mục từ cơ sở dữ liệu hoặc tương tự
//        return new ResponseEntity<>("Các mục đã đánh dấu đã được xóa.", HttpStatus.OK);
//}


}
