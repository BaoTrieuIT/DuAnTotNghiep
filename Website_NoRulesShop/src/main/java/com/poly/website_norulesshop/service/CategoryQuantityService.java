package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.CategoryQuantity;

import java.util.List;

public interface CategoryQuantityService {
    CategoryQuantity saveCategoryQuantity(CategoryQuantity categoryQuantity);

    CategoryQuantity getCategoryQuantityById(Integer id);

    List<CategoryQuantity> findByProductId(Integer id);

    List<CategoryQuantity> getAllCategoryQuantities();

    void deleteCategoryQuantity(Integer id);
}
