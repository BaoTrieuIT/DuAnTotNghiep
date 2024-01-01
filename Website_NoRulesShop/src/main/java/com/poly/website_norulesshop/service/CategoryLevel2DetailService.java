package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.CategoryLevel2Detail;
@Service
public interface CategoryLevel2DetailService {
    CategoryLevel2Detail saveCategoryLevel2Detail(CategoryLevel2Detail categoryLevel2Detail);

    CategoryLevel2Detail getCategoryLevel2DetailById(Integer id);

    List<CategoryLevel2Detail> getAllCategoryLevel2Details();

    void deleteCategoryLevel2Detail(Integer id);
}
