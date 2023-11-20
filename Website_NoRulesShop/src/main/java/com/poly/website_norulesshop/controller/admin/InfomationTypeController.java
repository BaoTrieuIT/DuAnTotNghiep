package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.DirectoryLv1;
import com.poly.website_norulesshop.entity.InformationType;
import com.poly.website_norulesshop.service.DirectoryLv1Service;
import com.poly.website_norulesshop.service.InformationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("rest/manage_info")
public class InfomationTypeController {
    @Autowired
    InformationTypeService informationTypeService;
    @Autowired
    DirectoryLv1Service directoryLv1Service;

    @GetMapping
    List<InformationType> GetBy(@RequestParam("byDirectoryLv1Id") Integer directoryLv1Id) {
        DirectoryLv1 directoryLv1 = directoryLv1Service.getDirectoryLv1ById(directoryLv1Id);
        return informationTypeService.getByDirectoryLv1(directoryLv1);
    }
}
