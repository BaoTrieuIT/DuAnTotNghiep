package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Các phương thức đặc thù cho bảng Order (nếu cần)
}
