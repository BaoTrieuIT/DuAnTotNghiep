package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.CategoryLevel1;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryLevel1Service {
    CategoryLevel1 saveCategoryLevel1(CategoryLevel1 categoryLevel1);

    CategoryLevel1 getCategoryLevel1ById(Long id);

    List<CategoryLevel1> getAllCategoryLevel1s();

    void deleteCategoryLevel1(Long id);
}
