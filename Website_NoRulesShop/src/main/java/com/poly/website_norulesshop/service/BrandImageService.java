package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.BrandImage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BrandImageService {
    BrandImage saveBrandImage(BrandImage brandImage);

    BrandImage getBrandImageById(Long id);

    List<BrandImage> getAllBrandImages();

    void deleteBrandImage(Long id);
}
