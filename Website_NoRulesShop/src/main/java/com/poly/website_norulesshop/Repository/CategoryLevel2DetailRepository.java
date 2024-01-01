package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.CategoryLevel2Detail;

@Repository
public interface CategoryLevel2DetailRepository extends JpaRepository<CategoryLevel2Detail, Integer> {
    // Các phương thức đặc thù cho bảng CategoryLevel2Detail (nếu cần)
}
