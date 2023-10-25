package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Các phương thức đặc thù cho bảng Product (nếu cần)
}
