package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.CategoryLevel2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryLevel2Repository extends JpaRepository<CategoryLevel2, Long> {
    // Các phương thức đặc thù cho bảng CategoryLevel2 (nếu cần)
}
