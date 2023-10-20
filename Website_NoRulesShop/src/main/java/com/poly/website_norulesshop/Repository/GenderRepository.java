package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {
    // Các phương thức truy vấn cụ thể nếu cần
}
