package com.poly.website_norulesshop.controller;

import com.poly.website_norulesshop.config.GlobalFlag;
import com.poly.website_norulesshop.entity.DirectoryLv1;
import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryQuantityService categoryQuantityService;

    @Autowired
    BrandService brandService;

    @Autowired
    ProductImageService productImageService;

    @Autowired
    CategoryLevel1DetailService categoryLevel1DetailService;

    @Autowired
    CategoryLevel2DetailService categoryLevel2DetailService;

    @Autowired
    GenderService genderService;

    @Autowired
    DirectoryService directoryService;

    @Autowired
    DirectoryLv1Service directoryLv1Service;

    @GetMapping({"/", "/home/index"})
    public String index(Model model) {
        List<Product> productList = productService.getAllProducts();
        List<DirectoryLv1> directoryLv1List = directoryLv1Service.getAllDirectoryLv1s();
        List<Product> filteredProduct = new ArrayList<>();
        for (DirectoryLv1 directoryLv1 : directoryLv1List) {
            List<Product> productDirectoryLv1 = productList.stream()
                    .filter(product ->
                            !product.getIsRemoved() &&
                                    Objects.equals(product.getDirectoryLv1().getDirectoryLv1Id(),
                                            directoryLv1.getDirectoryLv1Id())).collect(Collectors.toList());
            Collections.shuffle(productDirectoryLv1);
            List<Product> selectedProduct = productDirectoryLv1.stream().limit(1).toList();
            filteredProduct.addAll(selectedProduct);
        }
        model.addAttribute("title", "Trang chủ");
        model.addAttribute("filteredProduct", filteredProduct);
        GlobalFlag.flag_2 = false;
        return "/user/index";
    }
}
