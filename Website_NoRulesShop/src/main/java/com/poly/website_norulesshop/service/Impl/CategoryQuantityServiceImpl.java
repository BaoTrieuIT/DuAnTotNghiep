package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.CategoryQuantityRepository;
import com.poly.website_norulesshop.entity.CategoryQuantity;
import com.poly.website_norulesshop.service.CategoryQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryQuantityServiceImpl implements CategoryQuantityService {

    private final CategoryQuantityRepository categoryQuantityRepository;

    @Autowired
    public CategoryQuantityServiceImpl(CategoryQuantityRepository categoryQuantityRepository) {
        this.categoryQuantityRepository = categoryQuantityRepository;
    }

    @Override
    public CategoryQuantity saveCategoryQuantity(CategoryQuantity categoryQuantity) {
        return categoryQuantityRepository.save(categoryQuantity);
    }

    @Override
    public CategoryQuantity getCategoryQuantityById(Long id) {
        return categoryQuantityRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategoryQuantity> getAllCategoryQuantities() {
        return categoryQuantityRepository.findAll();
    }

    @Override
    public void deleteCategoryQuantity(Long id) {
        categoryQuantityRepository.deleteById(id);
    }
}
