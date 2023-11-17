package com.poly.website_norulesshop.Repository.Specification;

import com.poly.website_norulesshop.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public final class ProductSpecification {
    public static Specification<Product> findbyDirectoryId(Integer directoryId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("directoryLv1").get("directory").get("directoryId"), directoryId);
    }

    public static Specification<Product> findbyBrandId(Integer brandId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("brand").get("brandId"), brandId);
    }

    public static Specification<Product> findbyGenderId(Integer genderId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("directoryLv1").get("directory").get("gender").get("genderId"), genderId);
    }

    public static Specification<Product> findbyCategoryLV1Detail(Integer categoryLevel1DetailId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("categoryQuantityList").get("categoryLevel1Detail").get("category_level_1_detail_id"), categoryLevel1DetailId);
    }

    public static Specification<Product> findbyCategoryLV2Detail(Integer categoryLevel2DetailId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("categoryQuantityList").get("categoryLevel2Detail").get("category_level_2_detail_id"), categoryLevel2DetailId);
    }
}
