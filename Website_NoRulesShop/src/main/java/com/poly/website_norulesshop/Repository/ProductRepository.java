package com.poly.website_norulesshop.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Các phương thức đặc thù cho bảng Product (nếu cần)
    List<Product> findProductByProductNameLikeAndIsRemoved(String name, Boolean isRemove);

    List<Product> findProductByIsRemoved(Boolean isRemove);

    List<Product> findProductByProductNameLike(String name);

    @Query("SELECT o FROM Product o WHERE o.brand.brandId = ?1")
    Page<Product> findByBrandBrandId(String id, Pageable pageable);
}
