package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.CategoryLevel1Detail;
@Service
public interface CategoryLevel1DetailService {
    CategoryLevel1Detail saveCategoryLevel1Detail(CategoryLevel1Detail categoryLevel1Detail);

    CategoryLevel1Detail getCategoryLevel1DetailById(Integer id);

    List<CategoryLevel1Detail> getAllCategoryLevel1Details();

    void deleteCategoryLevel1Detail(Integer id);
}
