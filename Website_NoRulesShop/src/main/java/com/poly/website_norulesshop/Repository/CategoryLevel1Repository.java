package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.CategoryLevel1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryLevel1Repository extends JpaRepository<CategoryLevel1, Long> {
    // Các phương thức đặc thù cho bảng CategoryLevel1 (nếu cần)
}
