package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.entity.ProductImage;
import com.poly.website_norulesshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("home")
public class ProductPageController {
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

    @GetMapping("/product")
    public String getProductAll(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Product> productPage = productService.productPaginate(page, PAGE_SIZE);
//        Product p = new Product();
//        p.getProductId();
//        ProductImage productImage = new ProductImage();
//        productImage.getImage_url()
        model.addAttribute("productPage", productPage);
        model.addAttribute("title", "Sản phẩm");
        return "user/product_page";
    }

    @GetMapping("/product-details/productId={productId}")
    public String getProductDetails(Model model, @PathVariable("productId") int productId) {
        Product product = productService.getProductById(productId);
        List<ProductImage> productImageList = productImageService.findByProductId(productId);
        model.addAttribute("title", product.getProductName());
        model.addAttribute("products", product);
        model.addAttribute("productImages", productImageList);
        return "user/product_details";
    }
}
