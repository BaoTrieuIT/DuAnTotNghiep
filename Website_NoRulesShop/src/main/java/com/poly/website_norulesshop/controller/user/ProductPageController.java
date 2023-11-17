package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.entity.*;
import com.poly.website_norulesshop.service.*;
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
@SessionAttributes("filterCriteria")
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

    @Autowired
    GenderService genderService;

    @Autowired
    DirectoryService directoryService;

    @Autowired
    DirectoryLv1Service directoryLv1Service;

    @ModelAttribute("filterCriteria")
    public FilterCriteria geFilterCriteria() {
        return new FilterCriteria();
    }

    @GetMapping("/product")
    public String getProductAll(Model model,
                                @ModelAttribute("filterCriteria") FilterCriteria filterCriteria,
                                @RequestParam(defaultValue = "0") int page,
                                SessionStatus sessionStatus) {
        List<CategoryLevel2Detail> categoryLevel2Details = categoryLevel2DetailService.getAllCategoryLevel2Details();
        List<CategoryLevel1Detail> categoryLevel1Details = categoryLevel1DetailService.getAllCategoryLevel1Details();
        List<Gender> genders = genderService.getAllGenders();
        List<Directory> directoryList = directoryService.getAllDirectories();
        List<Brand> brandList = brandService.getAllBrands();
        Page<Product> productPage = productService.productPaginateWithFilter(
                filterCriteria.getBrandId(),
                filterCriteria.getDirectoryId(),
                filterCriteria.getGenderId(),
                filterCriteria.getCategoryLV1DetailId(),
                filterCriteria.getCategoryLV2DetailId(),
                filterCriteria.getPriceSort(),
                page,
                PAGE_SIZE);
        model.addAttribute("brandId", filterCriteria.getBrandId());
        model.addAttribute("directoryId", filterCriteria.getDirectoryId());
        model.addAttribute("genderId", filterCriteria.getGenderId());
        model.addAttribute("categoryLV1DetailId", filterCriteria.getCategoryLV1DetailId());
        model.addAttribute("categoryLV2DetailId", filterCriteria.getCategoryLV2DetailId());
        model.addAttribute("priceSort", filterCriteria.getPriceSort());

        model.addAttribute("directoryList", directoryList);
        model.addAttribute("brand", brandList);
        model.addAttribute("size", categoryLevel1Details);
        model.addAttribute("color", categoryLevel2Details);
        model.addAttribute("gender", genders);
        model.addAttribute("productPage", productPage);
        model.addAttribute("title", "Sản phẩm");
        return "user/product_page";
    }

    @GetMapping("/product/clear")
    public String clearFilter(Model model,
                              @ModelAttribute("filterCriteria") FilterCriteria filterCriteria,
                              @RequestParam(defaultValue = "0") int page,
                              SessionStatus sessionStatus) {
        filterCriteria.clear(); // Xóa thông tin bộ lọc
        sessionStatus.setComplete();
        List<CategoryLevel2Detail> categoryLevel2Details = categoryLevel2DetailService.getAllCategoryLevel2Details();
        List<CategoryLevel1Detail> categoryLevel1Details = categoryLevel1DetailService.getAllCategoryLevel1Details();
        List<Gender> genders = genderService.getAllGenders();
        List<Directory> directoryList = directoryService.getAllDirectories();
        List<Brand> brandList = brandService.getAllBrands();
        Page<Product> productPage = productService.productPaginateWithFilter(
                filterCriteria.getBrandId(),
                filterCriteria.getDirectoryId(),
                filterCriteria.getGenderId(),
                filterCriteria.getCategoryLV1DetailId(),
                filterCriteria.getCategoryLV2DetailId(),
                filterCriteria.getPriceSort(),
                page,
                PAGE_SIZE);
        model.addAttribute("brandId", filterCriteria.getBrandId());
        model.addAttribute("directoryId", filterCriteria.getDirectoryId());
        model.addAttribute("genderId", filterCriteria.getGenderId());
        model.addAttribute("categoryLV1DetailId", filterCriteria.getCategoryLV1DetailId());
        model.addAttribute("categoryLV2DetailId", filterCriteria.getCategoryLV2DetailId());
        model.addAttribute("priceSort", filterCriteria.getPriceSort());

        model.addAttribute("directoryList", directoryList);
        model.addAttribute("brand", brandList);
        model.addAttribute("size", categoryLevel1Details);
        model.addAttribute("color", categoryLevel2Details);
        model.addAttribute("gender", genders);
        model.addAttribute("productPage", productPage);
        model.addAttribute("title", "Sản phẩm");
        return "user/product_page";
    }

    @RequestMapping(value = "/product/filters", method = {RequestMethod.GET, RequestMethod.POST})
    public String handleFilterProduct(
            @ModelAttribute("filterCriteria") FilterCriteria filterCriteria,
            @RequestParam(name = "brandId", required = false) Integer brandId,
            @RequestParam(name = "directoryId", required = false) Integer directoryId,
            @RequestParam(name = "genderId", required = false) Integer genderId,
            @RequestParam(name = "categoryLV1DetailId", required = false) Integer categoryLV1DetailId,
            @RequestParam(name = "categoryLV2DetailId", required = false) Integer categoryLV2DetailId,
            @RequestParam(name = "priceSort", required = false) String priceSort,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            Model model,
            SessionStatus sessionStatus) {
        if (brandId != null
                || directoryId != null
                || genderId != null
                || categoryLV1DetailId != null
                || categoryLV2DetailId != null
                || priceSort != null) {
            filterCriteria.setBrandId(brandId);
            filterCriteria.setDirectoryId(directoryId);
            filterCriteria.setGenderId(genderId);
            filterCriteria.setCategoryLV1DetailId(categoryLV1DetailId);
            filterCriteria.setCategoryLV2DetailId(categoryLV2DetailId);
            filterCriteria.setPriceSort(priceSort);
        } else {
            if (filterCriteria.getBrandId() != null
                    || filterCriteria.getDirectoryId() != null
                    || filterCriteria.getGenderId() != null
                    || filterCriteria.getCategoryLV1DetailId() != null
                    || filterCriteria.getCategoryLV2DetailId() != null
                    || filterCriteria.getPriceSort() != null) {
                filterCriteria.clear(); // Xóa thông tin bộ lọc
                sessionStatus.setComplete();

            }
        }

        Page<Product> productPage = productService.productPaginateWithFilter(
                filterCriteria.getBrandId(),
                filterCriteria.getDirectoryId(),
                filterCriteria.getGenderId(),
                filterCriteria.getCategoryLV1DetailId(),
                filterCriteria.getCategoryLV2DetailId(),
                filterCriteria.getPriceSort(),
                page,
                PAGE_SIZE
        );

        List<CategoryLevel2Detail> categoryLevel2Details = categoryLevel2DetailService.getAllCategoryLevel2Details();
        List<CategoryLevel1Detail> categoryLevel1Details = categoryLevel1DetailService.getAllCategoryLevel1Details();
        List<Gender> genders = genderService.getAllGenders();
        List<Directory> directoryList = directoryService.getAllDirectories();
        List<Brand> brandList = brandService.getAllBrands();

        model.addAttribute("title", "Tất cả sản phẩm");
        model.addAttribute("brandId", filterCriteria.getBrandId());
        model.addAttribute("directoryId", filterCriteria.getDirectoryId());
        model.addAttribute("genderId", filterCriteria.getGenderId());
        model.addAttribute("categoryLV1DetailId", filterCriteria.getCategoryLV1DetailId());
        model.addAttribute("categoryLV2DetailId", filterCriteria.getCategoryLV2DetailId());
        model.addAttribute("priceSort", filterCriteria.getPriceSort());

        model.addAttribute("brand", brandList);
        model.addAttribute("directoryList", directoryList);
        model.addAttribute("size", categoryLevel1Details);
        model.addAttribute("color", categoryLevel2Details);
        model.addAttribute("gender", genders);

        model.addAttribute("productPage", productPage);

        return "user/product_page";
    }

    @GetMapping("/product-details/productId={productId}")
    public String getProductDetails(Model model, @PathVariable("productId") int productId) {
        Product product = productService.getProductById(productId);
        List<CategoryQuantity> categoryQuantityList = categoryQuantityService.findByProductId(productId);
        List<ProductImage> productImageList = productImageService.findByProductId(productId);
        model.addAttribute("title", product.getProductName());
        model.addAttribute("products", product);
        model.addAttribute("category", categoryQuantityList);

        model.addAttribute("productImages", productImageList);
        return "user/product_details";
    }
}
