package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.BrandRepository;
import com.poly.website_norulesshop.model.Brand;
import com.poly.website_norulesshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(int id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public Brand update(Brand brand) {
        return brandRepository.save(brand);
    }


    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
    @Override
    public void deleteBrand(int id) {
        brandRepository.deleteById(id);
    }
}
