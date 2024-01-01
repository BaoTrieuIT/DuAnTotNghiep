package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.BrandImage;
@Service
public interface BrandImageService {
    BrandImage saveBrandImage(BrandImage brandImage);

    BrandImage getBrandImageById(Integer id);

    List<BrandImage> getAllBrandImages();

    void deleteBrandImage(Integer id);
}
