package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    // Các phương thức đặc thù cho bảng OrderDetail (nếu cần)
    @Query("SELECT O FROM OrderDetail O WHERE O.order.orderId = :orderId")
    List<OrderDetail> findByOrderId(@Param("orderId") Integer orderId);

}
