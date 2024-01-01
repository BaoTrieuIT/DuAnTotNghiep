package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.CategoryLevel1;

@Repository
public interface CategoryLevel1Repository extends JpaRepository<CategoryLevel1, Integer> {
    // Các phương thức đặc thù cho bảng CategoryLevel1 (nếu cần)
}
