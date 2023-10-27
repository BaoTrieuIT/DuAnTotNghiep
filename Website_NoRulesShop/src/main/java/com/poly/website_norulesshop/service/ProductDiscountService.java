package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.ProductDiscount;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductDiscountService {
    ProductDiscount saveProductDiscount(ProductDiscount productDiscount);

    ProductDiscount getProductDiscountById(Long id);

    List<ProductDiscount> getAllProductDiscounts();

    void deleteProductDiscount(Long id);
}
