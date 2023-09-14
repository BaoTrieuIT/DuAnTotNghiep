package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.ProductImage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductImageService {
    ProductImage saveProductImage(ProductImage productImage);

    ProductImage getProductImageById(Long id);

    List<ProductImage> getAllProductImages();

    void deleteProductImage(Long id);
}
