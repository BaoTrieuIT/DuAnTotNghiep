package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    // Các phương thức đặc thù cho bảng Brand (nếu cần)
}
