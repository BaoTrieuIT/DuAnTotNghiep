package com.poly.website_norulesshop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    // Các phương thức đặc thù cho bảng Product (nếu cần)
    List<Product> findProductByProductNameLikeAndIsRemoved(String name, Boolean isRemove);

    List<Product> findProductByIsRemoved(Boolean isRemove);

    List<Product> findProductByProductNameLike(String name);


    @Query("SELECT p FROM Product p INNER JOIN p.productImageList pi WHERE p.productId = :productId")
    Product findProductWithImagesById(@Param("productId") Integer productId);

    @Query("SELECT o FROM Product o WHERE o.brand.brandId = ?1")
    Page<Product> findByBrandId(String id, Pageable pageable);

    @Query("SELECT o.totalQuantity FROM Product o WHERE o.productId = ?1")
    Integer getTotalById(Integer id);

    @Query("SELECT o FROM Product o WHERE o.brand.brandId = ?1")
    List<Product> findByBrandId(Integer brandId);
}
