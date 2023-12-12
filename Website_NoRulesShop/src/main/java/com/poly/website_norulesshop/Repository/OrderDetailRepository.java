package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    // Các phương thức đặc thù cho bảng OrderDetail (nếu cần)
    @Query("SELECT O FROM OrderDetail O WHERE O.order.orderId = :orderId")
    List<OrderDetail> findByOrderId(@Param("orderId") Integer orderId);

    @Query("SELECT COALESCE(SUM(od.quantity), 0) " +
            "FROM OrderDetail od " +
            "WHERE od.order.orderStatus.orderStatusId = 4 " +
            "AND YEAR(od.order.orderTime) = YEAR(CURRENT_DATE)")
    Integer countSalesAndYear();

    @Query("SELECT COALESCE(SUM(od.quantity), 0) " +
            "FROM OrderDetail od " +
            "WHERE od.order.orderStatus.orderStatusId = 4 " +
            "AND MONTH(od.order.orderTime) = MONTH(CURRENT_DATE) " +
            "AND YEAR(od.order.orderTime) = YEAR(CURRENT_DATE)")
    Integer countSalesAndMonth();

    @Query("SELECT COALESCE(SUM(od.quantity), 0) " +
            "FROM OrderDetail od " +
            "WHERE od.order.orderStatus.orderStatusId = 4 " +
            "AND DATE(od.order.orderTime) = CURRENT_DATE")
    Integer countSalesAndToday();

    @Query("DELETE FROM OrderDetail o WHERE o.order.orderId =: orderId")
    void deleteByOrderId(@Param("orderId") Integer orderId);
}
