package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.CategoryLevel1Repository;
import com.poly.website_norulesshop.entity.CategoryLevel1;
import com.poly.website_norulesshop.service.CategoryLevel1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryLevel1ServiceImpl implements CategoryLevel1Service {

    private final CategoryLevel1Repository categoryLevel1Repository;

    @Autowired
    public CategoryLevel1ServiceImpl(CategoryLevel1Repository categoryLevel1Repository) {
        this.categoryLevel1Repository = categoryLevel1Repository;
    }

    @Override
    public CategoryLevel1 saveCategoryLevel1(CategoryLevel1 categoryLevel1) {
        return categoryLevel1Repository.save(categoryLevel1);
    }

    @Override
    public CategoryLevel1 getCategoryLevel1ById(Long id) {
        return categoryLevel1Repository.findById(id).orElse(null);
    }

    @Override
    public List<CategoryLevel1> getAllCategoryLevel1s() {
        return categoryLevel1Repository.findAll();
    }

    @Override
    public void deleteCategoryLevel1(Long id) {
        categoryLevel1Repository.deleteById(id);
    }
}
