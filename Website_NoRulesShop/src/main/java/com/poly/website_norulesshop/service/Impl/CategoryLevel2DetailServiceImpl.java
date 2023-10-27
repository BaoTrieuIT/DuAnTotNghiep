package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.CategoryLevel2DetailRepository;
import com.poly.website_norulesshop.entity.CategoryLevel2Detail;
import com.poly.website_norulesshop.service.CategoryLevel2DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryLevel2DetailServiceImpl implements CategoryLevel2DetailService {

    private final CategoryLevel2DetailRepository categoryLevel2DetailRepository;

    @Autowired
    public CategoryLevel2DetailServiceImpl(CategoryLevel2DetailRepository categoryLevel2DetailRepository) {
        this.categoryLevel2DetailRepository = categoryLevel2DetailRepository;
    }

    @Override
    public CategoryLevel2Detail saveCategoryLevel2Detail(CategoryLevel2Detail categoryLevel2Detail) {
        return categoryLevel2DetailRepository.save(categoryLevel2Detail);
    }

    @Override
    public CategoryLevel2Detail getCategoryLevel2DetailById(Long id) {
        return categoryLevel2DetailRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategoryLevel2Detail> getAllCategoryLevel2Details() {
        return categoryLevel2DetailRepository.findAll();
    }

    @Override
    public void deleteCategoryLevel2Detail(Long id) {
        categoryLevel2DetailRepository.deleteById(id);
    }
}
