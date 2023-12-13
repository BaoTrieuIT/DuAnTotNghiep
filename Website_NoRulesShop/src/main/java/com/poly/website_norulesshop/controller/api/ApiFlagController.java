package com.poly.website_norulesshop.controller.api;

import com.poly.website_norulesshop.config.GlobalFlag;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController

public class ApiFlagController {
    @GetMapping("/rest/flag")
    public Boolean getFlag() {
        return GlobalFlag.flag_2;
    }
}
