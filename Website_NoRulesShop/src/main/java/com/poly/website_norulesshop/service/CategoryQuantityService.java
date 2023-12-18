package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.CategoryQuantity;
//import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface CategoryQuantityService {
    CategoryQuantity saveCategoryQuantity(CategoryQuantity categoryQuantity);

    CategoryQuantity getCategoryQuantityById(Integer id);

//    CategoryQuantity filter(Integer productId, Integer categoryLv1DetailId, Integer categoryLv2DetailId);

    List<CategoryQuantity> filterList(Integer productId, Integer categoryLv1DetailId, Integer categoryLv2DetailId);

//    List<CategoryQuantity> filterLv1orLv2(Integer productId, Integer categoryLv1DetailId, Integer categoryLv2DetailId);

    CategoryQuantity getOne(Integer productId, Integer categoryQuantityId);

    Integer getOne(Integer productId, Integer categoryLv1DetailId, Integer categoryLv2DetailId);

    List<CategoryQuantity> findByProductId(Integer id);

    List<CategoryQuantity> getAllCategoryQuantities();

    void deleteCategoryQuantity(Integer id);

    Integer getTotalQuantity(Integer productId, Integer categoryLv1DetailId, Integer categoryLv2DetailId);

    Integer getTotalQuantity(Integer productId, Integer categoryQuantityId);


}
