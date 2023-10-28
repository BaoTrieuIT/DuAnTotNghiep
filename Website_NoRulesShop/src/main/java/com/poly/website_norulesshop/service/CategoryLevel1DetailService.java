package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.CategoryLevel1Detail;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryLevel1DetailService {
    CategoryLevel1Detail saveCategoryLevel1Detail(CategoryLevel1Detail categoryLevel1Detail);

    CategoryLevel1Detail getCategoryLevel1DetailById(Long id);

    List<CategoryLevel1Detail> getAllCategoryLevel1Details();

    void deleteCategoryLevel1Detail(Long id);
}
