package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BrandService {
    Brand saveBrand(Brand brand);

    Brand getBrandById(Long id);

    List<Brand> getAllBrands();

    void deleteBrand(Long id);
}
