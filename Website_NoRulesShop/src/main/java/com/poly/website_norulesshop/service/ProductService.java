package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void saveProduct(Product product);

    Page<Product> productPaginate(int page, int pageSize);

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
