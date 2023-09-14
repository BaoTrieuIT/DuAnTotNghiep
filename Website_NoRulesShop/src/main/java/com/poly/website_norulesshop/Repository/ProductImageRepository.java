package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    // Các phương thức đặc thù cho bảng ProductImage (nếu cần)
}
