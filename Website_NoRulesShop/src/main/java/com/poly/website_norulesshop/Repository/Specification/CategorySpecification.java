package com.poly.website_norulesshop.Repository.Specification;

import com.poly.website_norulesshop.entity.CategoryQuantity;
import com.poly.website_norulesshop.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public final class CategorySpecification {
    public static Specification<CategoryQuantity> findbyProductID(Integer productId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("product").get("productId"), productId);
    }

    public static Specification<CategoryQuantity> findbyCategoryLV1Detail(Integer categoryLv1DetailId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("categoryLevel1Detail").get("category_level_1_detail_id"), categoryLv1DetailId);
    }

    public static Specification<CategoryQuantity> findbyCategoryLV2Detail(Integer categoryLv2DetailId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("categoryLevel2Detail").get("category_level_2_detail_id"), categoryLv2DetailId);
    }


}
