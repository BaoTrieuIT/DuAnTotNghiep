package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Ranked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankedRepository extends JpaRepository<Ranked, Long> {
    // Các phương thức đặc thù cho bảng Ranked (nếu cần)
}
