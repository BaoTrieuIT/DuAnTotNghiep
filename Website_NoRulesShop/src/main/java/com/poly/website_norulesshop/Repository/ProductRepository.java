package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Brand;
import com.poly.website_norulesshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.ListView;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Các phương thức đặc thù cho bảng Product (nếu cần)
    List<Product> findByProductNameLikeAndAndIsRemoved(String name, Boolean isRemove);
    List<Product> findProductByIsRemoved(Boolean isRemove);

    @Query("SELECT o FROM Product o WHERE o.brand.brandId = ?1")
    Page<Product> findByBrandBrandId(String id, Pageable pageable);
}
