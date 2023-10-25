package com.poly.website_norulesshop.controller.admin;


import com.poly.website_norulesshop.model.DetailInformationType;
import com.poly.website_norulesshop.model.InformationType;
import com.poly.website_norulesshop.service.DetailInformationTypeService;
import com.poly.website_norulesshop.service.InformationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/manage_DetailInfo")
public class DetailInfomationTypeController {

    @Autowired
    @Qualifier("detailInformationTypeService")
    DetailInformationTypeService detailinformationTypeService;

    @Autowired
    InformationTypeService informationTypeService;
    @GetMapping
    public List<DetailInformationType> detailInformationTypeList(){
        return detailinformationTypeService.getAllDetailInformationTypes();
    }

    @GetMapping("byInfo")
    public List<DetailInformationType> getByInfo(@RequestParam String InfoId){
        InformationType informationType =  informationTypeService.getInformationTypeById(Long.parseLong(InfoId));
        return detailinformationTypeService.getByInfomationType(informationType);
    }
}
