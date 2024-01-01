package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.CategoryLevel1Detail;

@Repository
public interface CategoryLevel1DetailRepository extends JpaRepository<CategoryLevel1Detail, Integer> {
    // Các phương thức đặc thù cho bảng CategoryLevel1Detail (nếu cần)
}
