package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.CategoryLevel2Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryLevel2DetailRepository extends JpaRepository<CategoryLevel2Detail, Long> {
    // Các phương thức đặc thù cho bảng CategoryLevel2Detail (nếu cần)
}
