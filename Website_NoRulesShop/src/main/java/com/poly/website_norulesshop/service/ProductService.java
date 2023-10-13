package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    Product saveProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProduct(Long id);

    List<Product> SearchByName(String productName);
}
