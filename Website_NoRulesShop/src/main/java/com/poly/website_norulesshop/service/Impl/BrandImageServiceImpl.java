package com.poly.website_norulesshop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.BrandImageRepository;
import com.poly.website_norulesshop.entity.BrandImage;
import com.poly.website_norulesshop.service.BrandImageService;

@Service
public class BrandImageServiceImpl implements BrandImageService {

    private final BrandImageRepository brandImageRepository;

    @Autowired
    public BrandImageServiceImpl(BrandImageRepository brandImageRepository) {
        this.brandImageRepository = brandImageRepository;
    }

    @Override
    public BrandImage saveBrandImage(BrandImage brandImage) {
        return brandImageRepository.save(brandImage);
    }

    @Override
    public BrandImage getBrandImageById(Integer id) {
        return brandImageRepository.findById(id).orElse(null);
    }

    @Override
    public List<BrandImage> getAllBrandImages() {
        return brandImageRepository.findAll();
    }

    @Override
    public void deleteBrandImage(Integer id) {
        brandImageRepository.deleteById(id);
    }
}
