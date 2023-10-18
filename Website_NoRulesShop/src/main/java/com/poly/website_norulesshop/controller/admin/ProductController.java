package com.poly.website_norulesshop.controller.admin;

import com.poly.website_norulesshop.model.Brand;
import com.poly.website_norulesshop.model.Product;
import com.poly.website_norulesshop.service.BrandService;
import com.poly.website_norulesshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product_all")
public class ProductController {
    @Autowired
    ProductService productService;

    Map<String, Boolean> softMap =  new HashMap<>();

    List<Product> listProduct = new ArrayList<>();
    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/searchByNameProductOnline")
    private List<Product> SearchByName(@RequestParam String productName,@RequestParam Integer min,@RequestParam Integer max){
        if(!productName.isEmpty()){
            return filterByPrice(productService.SearchProductActiveByName(productName),min,max);
        }else{
            return filterByPrice(productService.isActive(),min,max);
        }
    }

    @GetMapping("/searchByNameProductHidden")
    public List<Product> searchProductSoldoutByName(@RequestParam String productName,@RequestParam Integer min,@RequestParam Integer max){
        if(!productName.isEmpty()){
            return filterByPrice(productService.SearchProductHiddenByName(productName),min,max);
        }else{
            return filterByPrice(productService.isHidden(),min,max);
        }
    }

    @GetMapping("/searchByNameProductSoldout")
    public List<Product> SearchProductIsHiddenByName(@RequestParam String productName,@RequestParam Integer min,@RequestParam Integer max){
        if(!productName.isEmpty()){
            return filterByPrice(productService.SearchProductSoldoutByName(productName),min,max);
        }else{
            return filterByPrice(productService.isSoldOut(),min,max);
        }
    }

    @GetMapping("/isHidden")
    public List<Product> isHidden(){
        return productService.isHidden();
    }

    @GetMapping("/isActive")
    public List<Product> isActive(){
        return productService.isActive();
    }

    @GetMapping("/isSoldOut")
    public List<Product> isSoldOut(){
        return productService.isSoldOut();
    }


    @GetMapping("/hiddenProduct")
    public List<Product> HiddenProduct(@RequestParam String productId){
        Integer id = Integer.parseInt(productId);
        Product product = productService.getProductById(id);
        product.setIsRemoved(true);
        productService.saveProduct(product);
        return productService.isActive();
    }

    @GetMapping("/activeProduct")
    public List<Product> ActiveProduct(@RequestParam String productId){
        Integer id = Integer.parseInt(productId);
        Product product = productService.getProductById(id);
        product.setIsRemoved(false);
        productService.saveProduct(product);
        return productService.isHidden();
    }


    public List<Product> filterByPrice(List<Product> listProduct, Integer min, Integer max){

        List<Product> listToReturn = new ArrayList<>();
        for (Product product: listProduct) {
            if(min <= product.getPrice() && product.getPrice() <= max){
                listToReturn.add(product);
            }
        }
        if(listToReturn.isEmpty()){
            System.out.println("empty list");
        }
        System.out.println(min + " " + max );
        return listToReturn;
    }

//    @RequestMapping("product_all")
//    public static String product_all(){
//        return "admin/product_all";
//    }
//    @RequestMapping("product_add")
//    public static String product_add(){
//        return "admin/product_add";
//    }
//    @RequestMapping("product_report")
//    public static String product_report(){
//        return "admin/product_report";
//    }

}
