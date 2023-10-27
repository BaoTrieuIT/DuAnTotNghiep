package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
    // Các phương thức đặc thù cho bảng OrderStatus (nếu cần)
}
