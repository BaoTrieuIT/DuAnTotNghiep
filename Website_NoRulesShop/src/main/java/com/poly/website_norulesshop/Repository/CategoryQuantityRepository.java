package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.CategoryQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryQuantityRepository extends JpaRepository<CategoryQuantity, Integer> {
    // Các phương thức đặc thù cho bảng CategoryQuantity (nếu cần)
    @Query("SELECT cq FROM CategoryQuantity cq WHERE cq.product.productId = :productId ")
    List<CategoryQuantity> findByProductId(@Param("productId") Integer id);
}
