package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.CategoryLevel2Detail;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryLevel2DetailService {
    CategoryLevel2Detail saveCategoryLevel2Detail(CategoryLevel2Detail categoryLevel2Detail);

    CategoryLevel2Detail getCategoryLevel2DetailById(Long id);

    List<CategoryLevel2Detail> getAllCategoryLevel2Details();

    void deleteCategoryLevel2Detail(Long id);
}
