package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.CategoryLevel2;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryLevel2Service {
    CategoryLevel2 saveCategoryLevel2(CategoryLevel2 categoryLevel2);

    CategoryLevel2 getCategoryLevel2ById(Long id);

    List<CategoryLevel2> getAllCategoryLevel2s();

    void deleteCategoryLevel2(Long id);
}
