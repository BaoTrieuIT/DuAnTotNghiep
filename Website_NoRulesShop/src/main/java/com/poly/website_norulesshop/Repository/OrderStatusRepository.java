package com.poly.website_norulesshop.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.OrderStatus;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
    // Các phương thức đặc thù cho bảng OrderStatus (nếu cần)
    OrderStatus findByOrderStatusName(String statusName);
}
