package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.entity.Gender;
import com.poly.website_norulesshop.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/manage_gender")
public class GenderController {
    @Autowired
    GenderService genderService;
    @GetMapping
    public List<Gender> getAll(){
        return genderService.getAllGenders();
    }
}
