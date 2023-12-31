package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.ProductImage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductImageService {
    ProductImage saveProductImage(ProductImage productImage);

    ProductImage getProductImageById(Integer id);

    List<ProductImage> findByProductId(Integer id);

    List<ProductImage> findImageUrlByProductId(Integer id);

    List<ProductImage> getAllProductImages();

    void deleteProductImage(Integer id);
}
