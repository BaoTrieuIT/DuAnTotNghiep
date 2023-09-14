package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.CategoryQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryQuantityRepository extends JpaRepository<CategoryQuantity, Long> {
    // Các phương thức đặc thù cho bảng CategoryQuantity (nếu cần)
}
