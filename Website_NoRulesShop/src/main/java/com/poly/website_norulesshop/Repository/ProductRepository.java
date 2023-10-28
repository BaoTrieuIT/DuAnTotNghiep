package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Các phương thức đặc thù cho bảng Product (nếu cần)
  
}
