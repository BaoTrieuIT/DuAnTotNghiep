package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.ProductDiscountRepository;
import com.poly.website_norulesshop.entity.ProductDiscount;
import com.poly.website_norulesshop.service.ProductDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDiscountServiceImpl implements ProductDiscountService {

    private final ProductDiscountRepository productDiscountRepository;

    @Autowired
    public ProductDiscountServiceImpl(ProductDiscountRepository productDiscountRepository) {
        this.productDiscountRepository = productDiscountRepository;
    }

    @Override
    public ProductDiscount saveProductDiscount(ProductDiscount productDiscount) {
        return productDiscountRepository.save(productDiscount);
    }

    @Override
    public ProductDiscount getProductDiscountById(Long id) {
        return productDiscountRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductDiscount> getAllProductDiscounts() {
        return productDiscountRepository.findAll();
    }

    @Override
    public void deleteProductDiscount(Long id) {
        productDiscountRepository.deleteById(id);
    }
}
