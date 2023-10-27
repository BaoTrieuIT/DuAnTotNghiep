package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.ProductInformationType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductInformationTypeService {
    ProductInformationType saveProductInformationType(ProductInformationType productInformationType);

    ProductInformationType getProductInformationTypeById(Integer id);

    List<ProductInformationType> getAllProductInformationTypes();

    void deleteProductInformationType(Integer id);
}
