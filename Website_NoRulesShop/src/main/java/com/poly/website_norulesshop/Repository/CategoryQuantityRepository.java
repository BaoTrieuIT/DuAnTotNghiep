package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.CategoryQuantity;
import com.poly.website_norulesshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryQuantityRepository extends JpaRepository<CategoryQuantity, Integer>, JpaSpecificationExecutor<CategoryQuantity> {
    // Các phương thức đặc thù cho bảng CategoryQuantity (nếu cần)
    @Query("SELECT cq FROM CategoryQuantity cq WHERE cq.product.productId = :productId ")
    List<CategoryQuantity> findByProductId(@Param("productId") Integer id);

    @Query("SELECT cq FROM CategoryQuantity cq WHERE cq.product.productId = :productId " +
            "and cq.categoryLevel1Detail.category_level_1_detail_id = :categoryLv1Id")
    CategoryQuantity findByProductIdAndCategoryAndCategoryLevel1Detail(
            @Param("productId") Integer productId
            , @Param("categoryLv1Id") Integer categoryLv1Id);

    @Query("SELECT cq FROM CategoryQuantity cq WHERE cq.product.productId = :productId " +
            "and cq.categoryLevel2Detail.category_level_2_detail_id = :categoryLv2Id")
    CategoryQuantity findByProductIdAndCategoryAndCategoryLevel2Detail(
            @Param("productId") Integer productId
            , @Param("categoryLv2Id") Integer categoryLv2Id);

    @Query("SELECT cq FROM CategoryQuantity cq WHERE cq.product.productId = :productId " +
            "and cq.categoryLevel1Detail.category_level_1_detail_id = :categoryLv1Id " +
            "and cq.categoryLevel2Detail.category_level_2_detail_id = :categoryLv2Id")
    CategoryQuantity findByProductIdAndCategoryAndCategoryLevel1DetailAndCategoryLevel2Detail(
            @Param("productId") Integer productId
            , @Param("categoryLv1Id") Integer categoryLv1Id
            , @Param("categoryLv2Id") Integer categoryLv2Id);

    @Query("SELECT cq.quantity FROM CategoryQuantity cq WHERE cq.product.productId = :productId " +
            "and cq.categoryLevel1Detail.category_level_1_detail_id = :categoryLv1Id " +
            "and cq.categoryLevel2Detail.category_level_2_detail_id = :categoryLv2Id")
    Integer getQuantity(
            @Param("productId") Integer productId
            , @Param("categoryLv1Id") Integer categoryLv1Id
            , @Param("categoryLv2Id") Integer categoryLv2Id);
}
