package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.CategoryQuantity;

import java.util.List;

public interface CategoryQuantityService {
    CategoryQuantity saveCategoryQuantity(CategoryQuantity categoryQuantity);

    CategoryQuantity getCategoryQuantityById(Long id);

    List<CategoryQuantity> getAllCategoryQuantities();

    void deleteCategoryQuantity(Long id);
}
