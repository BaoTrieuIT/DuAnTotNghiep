package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.ProductInformationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInformationTypeRepository extends JpaRepository<ProductInformationType , Integer> {
}
