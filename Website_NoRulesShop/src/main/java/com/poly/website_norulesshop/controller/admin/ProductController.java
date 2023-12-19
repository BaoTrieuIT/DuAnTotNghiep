package com.poly.website_norulesshop.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.website_norulesshop.dto.EditProductDTO;
import com.poly.website_norulesshop.service.BrandService;
import com.poly.website_norulesshop.service.DirectoryLv1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.service.ProductService;

import javax.xml.transform.Result;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product_all")
public class ProductController {

    @Autowired
    ProductService productService;

    Map<String, Boolean> softMap = new HashMap<>();

    List<Product> listProduct = new ArrayList<>();


    @Autowired
    BrandService brandService;
    @Autowired
    DirectoryLv1Service directoryLv1Service;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }


    @GetMapping("/isHidden")
    public List<Product> isHidden() {
        return productService.isHidden();
    }

    @GetMapping("/isActive")
    public List<Product> isActive() {
        return productService.isActive();
    }

    @GetMapping("/isSoldOut")
    public List<Product> isSoldOut() {
        return productService.isSoldOut();
    }


    @GetMapping("/hiddenProduct")
    public List<Product> HiddenProduct(@RequestParam String productId) {
        Integer id = Integer.parseInt(productId);
        Product product = productService.getProductById(id);
        product.setIsRemoved(true);
        productService.saveProduct(product);
        return productService.isActive();
    }

    @GetMapping("/activeProduct")
    public List<Product> ActiveProduct(@RequestParam String productId) {
        Integer id = Integer.parseInt(productId);
        Product product = productService.getProductById(id);
        product.setIsRemoved(false);
        productService.saveProduct(product);
        return productService.isHidden();
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        if(product.getPriceNew() == product.getPriceNew()){
            product.setDiscount(null);
        }else{
            product.setDiscount((product.getPriceOld() - product.getPriceNew())/product.getPriceOld());
        }
        productService.saveProduct(product);
        return product;
    }
}
