package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.ProductImageRepository;
import com.poly.website_norulesshop.entity.ProductImage;
import com.poly.website_norulesshop.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageServiceImpl(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    @Override
    public ProductImage saveProductImage(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public ProductImage getProductImageById(Integer id) {
        return productImageRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductImage> findByProductId(Integer id) {
        return productImageRepository.findByProduct_id(id);
    }

    @Override
    public List<ProductImage> findImageUrlByProductId(Integer id) {
        return productImageRepository.findImageByProduct_id(id);
    }

    @Override
    public List<ProductImage> getAllProductImages() {
        return productImageRepository.findAll();
    }

    @Override
    public void deleteProductImage(Integer id) {
        productImageRepository.deleteById(id);
    }
}
