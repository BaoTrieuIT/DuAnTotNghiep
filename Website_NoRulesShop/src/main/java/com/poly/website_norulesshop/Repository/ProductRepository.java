package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.ListView;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Các phương thức đặc thù cho bảng Product (nếu cần)
    List<Product> findByProductNameLike(String name);
}
