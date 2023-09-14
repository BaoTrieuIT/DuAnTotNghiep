package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    // Các phương thức đặc thù cho bảng OrderDetail (nếu cần)
}
