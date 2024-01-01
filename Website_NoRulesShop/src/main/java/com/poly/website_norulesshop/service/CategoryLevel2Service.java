package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.CategoryLevel2;
@Service
public interface CategoryLevel2Service {
    CategoryLevel2 saveCategoryLevel2(CategoryLevel2 categoryLevel2);

    CategoryLevel2 getCategoryLevel2ById(Integer id);

    List<CategoryLevel2> getAllCategoryLevel2s();

    void deleteCategoryLevel2(Integer id);
}
