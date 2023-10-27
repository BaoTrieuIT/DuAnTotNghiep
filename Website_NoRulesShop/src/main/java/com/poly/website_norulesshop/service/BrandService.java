package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BrandService {
    Brand saveBrand(Brand brand);

    Brand getBrandById(int id);

    Brand update(Brand brand);

    List<Brand> getAllBrands();
    void deleteBrand(int id);
}
