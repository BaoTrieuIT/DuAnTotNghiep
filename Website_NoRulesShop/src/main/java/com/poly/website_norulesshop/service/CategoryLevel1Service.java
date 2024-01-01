package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.CategoryLevel1;
@Service
public interface CategoryLevel1Service {
    CategoryLevel1 saveCategoryLevel1(CategoryLevel1 categoryLevel1);

    CategoryLevel1 getCategoryLevel1ById(Integer id);

    List<CategoryLevel1> getAllCategoryLevel1s();

    void deleteCategoryLevel1(Integer id);
}
