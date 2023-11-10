package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    // Các phương thức đặc thù cho bảng ProductImage (nếu cần)
    @Query("SELECT image FROM ProductImage image INNER JOIN image.product where image.product.productId = ?1")
    List<ProductImage> findByProduct_id(Integer productId);
}
