package com.poly.website_norulesshop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.CategoryLevel1DetailRepository;
import com.poly.website_norulesshop.entity.CategoryLevel1Detail;
import com.poly.website_norulesshop.service.CategoryLevel1DetailService;

@Service
public class CategoryLevel1DetailServiceImpl implements CategoryLevel1DetailService {

    private final CategoryLevel1DetailRepository categoryLevel1DetailRepository;

    @Autowired
    public CategoryLevel1DetailServiceImpl(CategoryLevel1DetailRepository categoryLevel1DetailRepository) {
        this.categoryLevel1DetailRepository = categoryLevel1DetailRepository;
    }

    @Override
    public CategoryLevel1Detail saveCategoryLevel1Detail(CategoryLevel1Detail categoryLevel1Detail) {
        return categoryLevel1DetailRepository.save(categoryLevel1Detail);
    }

    @Override
    public CategoryLevel1Detail getCategoryLevel1DetailById(Integer id) {
        return categoryLevel1DetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategoryLevel1Detail> getAllCategoryLevel1Details() {
        return categoryLevel1DetailRepository.findAll();
    }

    @Override
    public void deleteCategoryLevel1Detail(Integer id) {
        categoryLevel1DetailRepository.deleteById(id);
    }
}
