package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.BrandImage;

@Repository
public interface BrandImageRepository extends JpaRepository<BrandImage, Integer> {
    // Các phương thức đặc thù cho bảng BrandImage (nếu cần)
}
