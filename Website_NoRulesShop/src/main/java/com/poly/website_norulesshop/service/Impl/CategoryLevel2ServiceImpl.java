package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.CategoryLevel2Repository;
import com.poly.website_norulesshop.model.CategoryLevel2;
import com.poly.website_norulesshop.service.CategoryLevel2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryLevel2ServiceImpl implements CategoryLevel2Service {

    private final CategoryLevel2Repository categoryLevel2Repository;

    @Autowired
    public CategoryLevel2ServiceImpl(CategoryLevel2Repository categoryLevel2Repository) {
        this.categoryLevel2Repository = categoryLevel2Repository;
    }

    @Override
    public CategoryLevel2 saveCategoryLevel2(CategoryLevel2 categoryLevel2) {
        return categoryLevel2Repository.save(categoryLevel2);
    }

    @Override
    public CategoryLevel2 getCategoryLevel2ById(Long id) {
        return categoryLevel2Repository.findById(id).orElse(null);
    }

    @Override
    public List<CategoryLevel2> getAllCategoryLevel2s() {
        return categoryLevel2Repository.findAll();
    }

    @Override
    public void deleteCategoryLevel2(Long id) {
        categoryLevel2Repository.deleteById(id);
    }
}
