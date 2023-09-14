package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsRepository extends JpaRepository<Points, Long> {
    // Các phương thức đặc thù cho bảng Points (nếu cần)
}
