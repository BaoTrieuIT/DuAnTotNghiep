package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.Ranked;

@Repository
public interface RankedRepository extends JpaRepository<Ranked, Integer> {
    // Các phương thức đặc thù cho bảng Ranked (nếu cần)
}
