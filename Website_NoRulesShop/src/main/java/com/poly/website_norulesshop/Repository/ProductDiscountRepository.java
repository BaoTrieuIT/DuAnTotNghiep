package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Long> {
    // Các phương thức đặc thù cho bảng ProductDiscount (nếu cần)
}
