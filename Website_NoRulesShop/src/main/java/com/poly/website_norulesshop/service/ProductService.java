package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    void saveProduct(Product product);

    Product getProductById(Integer id);

    List<Product> getAllProducts();

    void deleteProduct(Integer id);

    List<Product> SearchProductActiveByName(String productName);
    List<Product> SearchProductHiddenByName(String productName);
    List<Product> SearchProductSoldoutByName(String productName);




    List<Product> isHidden();
    List<Product> isActive();
    List<Product> isSoldOut();
}
