package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.CategoryLevel2;

@Repository
public interface CategoryLevel2Repository extends JpaRepository<CategoryLevel2, Integer> {
    // Các phương thức đặc thù cho bảng CategoryLevel2 (nếu cần)
}
