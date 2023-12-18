package com.poly.website_norulesshop.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product_all")
public class ProductController {

    @Autowired
    ProductService productService;

    Map<String, Boolean> softMap = new HashMap<>();

    List<Product> listProduct = new ArrayList<>();

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


    public List<Product> filterByPrice(List<Product> listProduct, Integer min, Integer max) {

        List<Product> listToReturn = new ArrayList<>();
        if (listProduct.isEmpty()) {
        } else {
            for (Product product : listProduct) {
                if ((product.getPriceNew() <= max && product.getPriceNew() > min) || (product.getPriceNew() <= max && product.getPriceNew() > min)) {
                    listToReturn.add(product);
                }
            }
        }
        if (listToReturn.isEmpty()) {
        }
        return listToReturn;
    }
}
