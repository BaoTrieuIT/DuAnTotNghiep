package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.*;
import com.poly.website_norulesshop.service.*;
import com.poly.website_norulesshop.utils.FilterCategoryCriteria;
import com.poly.website_norulesshop.utils.FilterCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("home")
public class ProductDetailController {
    private static final int PAGE_SIZE = 6;
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


    @GetMapping("/product-details/productId={productId}")
    public String getProductDetails(Model model, @PathVariable("productId") int productId) {
        Product product = productService.getProductById(productId);
        List<CategoryQuantity> categoryQuantityList = categoryQuantityService.findByProductId(productId);
        List<ProductImage> productImageList = productImageService.findByProductId(productId);
        model.addAttribute("title", product.getProductName());
        model.addAttribute("products", product);
        model.addAttribute("category", categoryQuantityList);
        System.out.println(categoryQuantityList);
        model.addAttribute("productImages", productImageList);
        model.addAttribute("categoryLv1Id", null);
        model.addAttribute("categoryLv2Id", null);
        return "user/product_details";
    }

    @GetMapping("/product-details/clear")
    public String clear(Model model, @RequestParam("productId") Integer productId) {
        Product product = productService.getProductById(productId);
        List<CategoryQuantity> categoryQuantityList = categoryQuantityService.findByProductId(productId);
        List<ProductImage> productImageList = productImageService.findByProductId(productId);
        model.addAttribute("title", product.getProductName());
        model.addAttribute("products", product);
        model.addAttribute("category", categoryQuantityList);
        model.addAttribute("productImages", productImageList);
        model.addAttribute("categoryLv1Id", null);
        model.addAttribute("categoryLv2Id", null);
        return "user/product_details";
    }

    @RequestMapping(value = "/product-details/filter", method = {RequestMethod.GET, RequestMethod.POST})
    public String filterCategory(Model model,
                                 @RequestParam("productId") Integer productId,
                                 @RequestParam(name = "categoryLv1Id", required = false) Integer categoryLv1Id,
                                 @RequestParam(name = "categoryLv2Id", required = false) Integer categoryLv2Id
    ) {
        Product product = productService.getProductById(productId);
        if (categoryLv1Id != null
                || categoryLv2Id != null
        ) {
            CategoryQuantity categoryQuantityList = categoryQuantityService.filter(productId, categoryLv1Id, categoryLv2Id);
            model.addAttribute("category", categoryQuantityList);
            model.addAttribute("categoryLv1Id", categoryLv1Id);
            model.addAttribute("categoryLv2Id", categoryLv2Id);
        } else {
            List<CategoryQuantity> categoryQuantityList = categoryQuantityService.findByProductId(productId);
            model.addAttribute("category", categoryQuantityList);
            System.out.println(categoryQuantityList);

        }
        List<ProductImage> productImageList = productImageService.findByProductId(productId);
        model.addAttribute("title", product.getProductName());
        model.addAttribute("products", product);
        model.addAttribute("productImages", productImageList);

        return "user/product_details";
    }


}
