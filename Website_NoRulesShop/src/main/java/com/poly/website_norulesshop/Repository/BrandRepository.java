package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    // Các phương thức đặc thù cho bảng Brand (nếu cần)
}
