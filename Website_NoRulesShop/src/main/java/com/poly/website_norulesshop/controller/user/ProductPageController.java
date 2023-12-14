package com.poly.website_norulesshop.controller.user;

import com.poly.website_norulesshop.config.GlobalFlag;
import com.poly.website_norulesshop.entity.*;
import com.poly.website_norulesshop.service.*;
import com.poly.website_norulesshop.utils.FilterCategoryCriteria;
import com.poly.website_norulesshop.utils.FilterCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("home")
@SessionAttributes("filterCriteria")
public class ProductPageController {
    private static final int PAGE_SIZE = 8;
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
        List<Directory> directoryList = directoryService.getAllDirectories();
        List<DirectoryLv1> directoryLV1List = directoryLv1Service.getAllDirectoryLv1s();
        List<Brand> brandList = brandService.getAllBrands();

        Page<Product> productPage = productService.productPaginateWithFilter(
                filterCriteria.getBrandId(),
                filterCriteria.getDirectoryLv1Id(),
                null,
                filterCriteria.getPriceSort(),
                page,
                PAGE_SIZE);
        GlobalFlag.flag_2 = false;

        model.addAttribute("brandId", filterCriteria.getBrandId());
        model.addAttribute("directoryId", filterCriteria.getDirectoryLv1Id());
        model.addAttribute("priceSort", filterCriteria.getPriceSort());
        model.addAttribute("directoryList", directoryList);
        model.addAttribute("directoryLV1List", directoryLV1List);
        model.addAttribute("brand", brandList);
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
        List<Directory> directoryList = directoryService.getAllDirectories();
        List<DirectoryLv1> directoryLV1List = directoryLv1Service.getAllDirectoryLv1s();
        List<Brand> brandList = brandService.getAllBrands();
        Page<Product> productPage = productService.productPaginateWithFilter(
                filterCriteria.getBrandId(),
                filterCriteria.getDirectoryLv1Id(),
                null,
                filterCriteria.getPriceSort(),
                page,
                PAGE_SIZE);
        model.addAttribute("brandId", filterCriteria.getBrandId());
        model.addAttribute("directoryId", filterCriteria.getDirectoryLv1Id());
        model.addAttribute("priceSort", filterCriteria.getPriceSort());
        model.addAttribute("directoryList", directoryList);
        model.addAttribute("directoryLV1List", directoryLV1List);
        model.addAttribute("brand", brandList);
        model.addAttribute("productPage", shufflePageContent(productPage));
        model.addAttribute("title", "Sản phẩm");
        return "redirect:/home/product";
    }

    @RequestMapping(value = "/product/filters", method = {RequestMethod.GET, RequestMethod.POST})
    public String handleFilterProduct(
            @ModelAttribute("filterCriteria") FilterCriteria filterCriteria,
            @RequestParam(name = "brandId", required = false) Integer brandId,
            @RequestParam(name = "directoryLv1Id", required = false) Integer directoryLv1Id,
            @RequestParam(name = "priceSort", required = false) String priceSort,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            Model model,
            SessionStatus sessionStatus) {
        if (brandId != null
                || directoryLv1Id != null
                || priceSort != null) {
            filterCriteria.setBrandId(brandId);
            filterCriteria.setDirectoryLv1Id(directoryLv1Id);
            filterCriteria.setPriceSort(priceSort);
        } else {
            if (filterCriteria.getBrandId() != null
                    || filterCriteria.getDirectoryLv1Id() != null
                    || filterCriteria.getPriceSort() != null) {
                filterCriteria.clear(); // Xóa thông tin bộ lọc
                sessionStatus.setComplete();

            }
        }

        Page<Product> productPage = productService.productPaginateWithFilter(
                filterCriteria.getBrandId(),
                filterCriteria.getDirectoryLv1Id(),
                null,
                filterCriteria.getPriceSort(),
                page,
                PAGE_SIZE
        );
        List<Directory> directoryList = directoryService.getAllDirectories();
        List<DirectoryLv1> directoryLV1List = directoryLv1Service.getAllDirectoryLv1s();
        List<Brand> brandList = brandService.getAllBrands();

        model.addAttribute("title", "Tất cả sản phẩm");
        model.addAttribute("brandId", filterCriteria.getBrandId());
        model.addAttribute("directoryLv1Id", filterCriteria.getDirectoryLv1Id());
        model.addAttribute("priceSort", filterCriteria.getPriceSort());
        model.addAttribute("directoryList", directoryList);
        model.addAttribute("brand", brandList);
        model.addAttribute("directoryLV1List", directoryLV1List);
        model.addAttribute("productPage", productPage);

        return "user/product_page";
    }

    @RequestMapping("/search")
    public String searchProducts(Model model, @Param("keyword") String keyword, @ModelAttribute("filterCriteria") FilterCriteria filterCriteria, @RequestParam(defaultValue = "0") int page) {
        System.out.println(keyword);
        Page<Product> productPage = productService.productPaginateWithFilter(
                filterCriteria.getBrandId(),
                filterCriteria.getDirectoryLv1Id(),
                keyword,
                filterCriteria.getPriceSort(),
                page,
                PAGE_SIZE
        );
        List<Directory> directoryList = directoryService.getAllDirectories();
        List<DirectoryLv1> directoryLV1List = directoryLv1Service.getAllDirectoryLv1s();
        List<Brand> brandList = brandService.getAllBrands();
        model.addAttribute("brandId", filterCriteria.getBrandId());
        model.addAttribute("directoryLv1Id", filterCriteria.getDirectoryLv1Id());
        model.addAttribute("priceSort", filterCriteria.getPriceSort());
        model.addAttribute("directoryList", directoryList);
        model.addAttribute("brand", brandList);
        model.addAttribute("directoryLV1List", directoryLV1List);
        model.addAttribute("title", "Tất cả sản phẩm");
        model.addAttribute("productPage", productPage
        );
        return "user/product_page";
    }

    private Page<Product> shufflePageContent(Page<Product> page) {
        List<Product> shuffledProducts = new ArrayList<>(page.getContent());
        Collections.shuffle(shuffledProducts);
        return new PageImpl<>(shuffledProducts, page.getPageable(), page.getTotalElements());
    }
}
