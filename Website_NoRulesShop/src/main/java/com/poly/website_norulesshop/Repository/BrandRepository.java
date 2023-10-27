package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    // Các phương thức đặc thù cho bảng Brand (nếu cần)
}
