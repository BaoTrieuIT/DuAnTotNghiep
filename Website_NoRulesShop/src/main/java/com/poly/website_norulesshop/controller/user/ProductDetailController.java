package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.*;
import com.poly.website_norulesshop.service.*;
import com.poly.website_norulesshop.utils.FilterCategoryCriteria;
import com.poly.website_norulesshop.utils.FilterCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.Collections;
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


    @GetMapping("/product-details/productId={productId}/brandId={brandId}")
    public String getProductDetails(Model model,
                                    @PathVariable("productId") int productId,
                                    @PathVariable("brandId") int brandId) {

        Product product = productService.getProductById(productId);
        List<Product> productsBrand = productService.getProductByBrandId(brandId);
        List<CategoryQuantity> categoryQuantityList = categoryQuantityService.findByProductId(productId);
        List<ProductImage> productImageList = productImageService.findByProductId(productId);
        Brand brand = brandService.getBrandById(brandId);
        model.addAttribute("title", product.getProductName());
        model.addAttribute("products", product);
        model.addAttribute("brand", brand);
        model.addAttribute("productsRelate", shufflePageContent(productsBrand));
        model.addAttribute("category", categoryQuantityList);
        model.addAttribute("productImages", productImageList);
        model.addAttribute("categoryQuantityId", null);
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
        model.addAttribute("categoryQuantityId", null);
        model.addAttribute("categoryLv1Id", null);
        model.addAttribute("categoryLv2Id", null);
        return "user/product_details";
    }

    @RequestMapping(value = "/product-details/filter", method = {RequestMethod.GET, RequestMethod.POST})
    public String filterCategory(Model model,
                                 @RequestParam("productId") Integer productId,
                                 @RequestParam("brandId") Integer brandId,
                                 @RequestParam(name = "categoryLv1Id", required = false) Integer categoryLv1Id,
                                 @RequestParam(name = "categoryLv2Id", required = false) Integer categoryLv2Id
    ) {
        Product product = productService.getProductById(productId);
        if (categoryLv1Id != null || categoryLv2Id != null) {
            List<CategoryQuantity> categoryQuantityList = categoryQuantityService.filterList(productId, categoryLv1Id, categoryLv2Id);
            Integer categoryQuantity = categoryQuantityService.getTotalQuantity(productId, categoryLv1Id, categoryLv2Id);
            Integer categoryQuantityId = categoryQuantityService.getOne(productId, categoryLv1Id, categoryLv2Id);

            model.addAttribute("category", categoryQuantityList);
            model.addAttribute("categoryQuantityId", categoryQuantityId);
            model.addAttribute("categoryLv1Id", categoryLv1Id);
            model.addAttribute("categoryLv2Id", categoryLv2Id);
            model.addAttribute("quantity", categoryQuantity);
        } else {
            List<CategoryQuantity> categoryQuantityList = categoryQuantityService.findByProductId(productId);
            model.addAttribute("category", categoryQuantityList);
            model.addAttribute("quantity", -1);
        }
        List<Product> productsBrand = productService.getProductByBrandId(brandId);
        model.addAttribute("productsRelate", shufflePageContent(productsBrand));
        List<ProductImage> productImageList = productImageService.findByProductId(productId);
        model.addAttribute("title", product.getProductName());
        model.addAttribute("products", product);
        model.addAttribute("productImages", productImageList);
        return "user/product_details";
    }

    private List<Product> shufflePageContent(List<Product> products) {
        List<Product> shuffledProducts = new ArrayList<>(products);
        Collections.shuffle(shuffledProducts);
        return shuffledProducts;
    }
}
