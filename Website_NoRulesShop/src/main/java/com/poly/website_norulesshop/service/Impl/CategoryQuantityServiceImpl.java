package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.CategoryQuantityRepository;
import com.poly.website_norulesshop.Repository.Specification.CategorySpecification;
import com.poly.website_norulesshop.Repository.Specification.ProductSpecification;
import com.poly.website_norulesshop.entity.CategoryQuantity;
import com.poly.website_norulesshop.entity.Product;
import com.poly.website_norulesshop.service.CategoryQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    public CategoryQuantity getCategoryQuantityById(Integer id) {
        return categoryQuantityRepository.findById(id).orElse(null);
    }

    //    @Override
//    public CategoryQuantity filter(Integer productId, Integer categoryLv1DetailId, Integer categoryLv2DetailId) {
//        return categoryQuantityRepository.findByProductIdAndCategoryAndCategoryLevel1DetailAndCategoryLevel2Detail(productId, categoryLv1DetailId, categoryLv1DetailId);
//    }
//
    @Override
    public List<CategoryQuantity> filterList(Integer productId, Integer categoryLv1DetailId, Integer categoryLv2DetailId) {
        if (categoryLv1DetailId != null && categoryLv2DetailId == null) {
            return categoryQuantityRepository.findByCategoryLv1(productId, categoryLv1DetailId);
        }
        if (categoryLv2DetailId != null && categoryLv1DetailId == null) {
            return categoryQuantityRepository.findByCategoryLv2(productId, categoryLv2DetailId);
        }
        return categoryQuantityRepository.findByCategoryLv1AndLv2(productId, categoryLv1DetailId, categoryLv2DetailId);
    }
//
//    @Override
//    public List<CategoryQuantity> filterLv1orLv2(Integer productId, Integer categoryLv1DetailId, Integer categoryLv2DetailId) {
//        if (categoryLv1DetailId != null) {
//            return categoryQuantityRepository.findByProductIdAndCategoryAndCategoryLevel1Detail(productId, categoryLv1DetailId);
//        }
//        return categoryQuantityRepository.findByProductIdAndCategoryAndCategoryLevel2Detail(productId, categoryLv2DetailId);
//    }


    @Override
    public List<CategoryQuantity> findByProductId(Integer productId) {
        return categoryQuantityRepository.findByProductId(productId);
    }

    @Override
    public List<CategoryQuantity> getAllCategoryQuantities() {
        return categoryQuantityRepository.findAll();
    }

    @Override
    public void deleteCategoryQuantity(Integer id) {
        categoryQuantityRepository.deleteById(id);
    }

    @Override
    public Integer getTotalQuantity(Integer productId, Integer categoryLv1DetailId, Integer categoryLv2DetailId) {
        return categoryQuantityRepository.getQuantity(productId, categoryLv1DetailId, categoryLv2DetailId);
    }
}
