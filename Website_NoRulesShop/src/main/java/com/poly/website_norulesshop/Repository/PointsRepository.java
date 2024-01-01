package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.Points;

@Repository
public interface PointsRepository extends JpaRepository<Points, Integer> {
    // Các phương thức đặc thù cho bảng Points (nếu cần)
}
