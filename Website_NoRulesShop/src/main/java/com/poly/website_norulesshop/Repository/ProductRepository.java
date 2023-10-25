package com.poly.website_norulesshop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Các phương thức đặc thù cho bảng Product (nếu cần)
    List<Product> findByProductNameLikeAndAndIsRemoved(String name, Boolean isRemove);
    List<Product> findProductByIsRemoved(Boolean isRemove);
}
