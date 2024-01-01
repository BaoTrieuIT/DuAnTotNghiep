package com.poly.website_norulesshop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.Order;
import com.poly.website_norulesshop.entity.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o where o.account.account_id = :accountId")
    List<Order> findByAccountId(@Param("accountId") Integer accountId);


    @Query("SELECT COALESCE(SUM(o.totalPrice), 0) " +
            "FROM Order o " +
            "WHERE o.orderStatus.orderStatusId = 4 " +
            "AND YEAR(o.orderUpdateTime) = YEAR(CURRENT_DATE)")
    Integer countRevenueAndYear();

    @Query("SELECT COALESCE(SUM(o.totalPrice), 0) " +
            "FROM Order o " +
            "WHERE o.orderStatus.orderStatusId = 4 " +
            "AND MONTH(o.orderUpdateTime) = MONTH(CURRENT_DATE)")
    Integer countRevenueAndMonth();

    @Query("SELECT COALESCE(SUM(o.totalPrice), 0) " +
            "FROM Order o " +
            "WHERE o.orderStatus.orderStatusId = 4 " +
            "AND DATE(o.orderUpdateTime) = CURRENT_DATE")
    Integer countRevenueAndToday();

    @Query("SELECT MONTH(e.orderUpdateTime) as month, YEAR(e.orderUpdateTime) as year, SUM(e.totalPrice) as totalRevenue " +
            "FROM Order e " +
            "WHERE e.orderStatus.orderStatusId = 4 " +
            "GROUP BY MONTH(e.orderUpdateTime), YEAR(e.orderUpdateTime)")
    List<Object[]> getRevenueByMonth();

    List<Order> findByOrderStatus(OrderStatus orderStatus);
}
