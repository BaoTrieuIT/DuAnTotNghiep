package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.CategoryLevel1Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryLevel1DetailRepository extends JpaRepository<CategoryLevel1Detail, Long> {
    // Các phương thức đặc thù cho bảng CategoryLevel1Detail (nếu cần)
}
