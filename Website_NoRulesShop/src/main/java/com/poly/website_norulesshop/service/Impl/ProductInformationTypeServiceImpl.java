package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.model.ProductInformationType;
import com.poly.website_norulesshop.Repository.ProductInformationTypeRepository;
import com.poly.website_norulesshop.service.ProductInformationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInformationTypeServiceImpl implements ProductInformationTypeService {

    private final ProductInformationTypeRepository productInformationTypeRepository;

    @Autowired
    public ProductInformationTypeServiceImpl(ProductInformationTypeRepository productInformationTypeRepository) {
        this.productInformationTypeRepository = productInformationTypeRepository;
    }

    @Override
    public ProductInformationType saveProductInformationType(ProductInformationType productInformationType) {
        return productInformationTypeRepository.save(productInformationType);
    }

    @Override
    public ProductInformationType getProductInformationTypeById(Integer id) {
        return productInformationTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductInformationType> getAllProductInformationTypes() {
        return productInformationTypeRepository.findAll();
    }

    @Override
    public void deleteProductInformationType(Integer id) {
        productInformationTypeRepository.deleteById(id);
    }
}
