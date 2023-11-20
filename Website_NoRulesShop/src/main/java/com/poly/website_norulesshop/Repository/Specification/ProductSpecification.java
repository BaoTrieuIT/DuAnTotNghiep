package com.poly.website_norulesshop.Repository.Specification;

import com.poly.website_norulesshop.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public final class ProductSpecification {
    public static Specification<Product> findbyDirectoryLV1Id(Integer directoryLv1Id) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("directoryLv1").get("directoryLv1Id"), directoryLv1Id);
    }

    public static Specification<Product> findbyBrandId(Integer brandId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("brand").get("brandId"), brandId);
    }

    
}
