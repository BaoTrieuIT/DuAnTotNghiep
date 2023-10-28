package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.BrandImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandImageRepository extends JpaRepository<BrandImage, Long> {
    // Các phương thức đặc thù cho bảng BrandImage (nếu cần)
}
