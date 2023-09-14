package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {
    // Các phương thức đặc thù cho bảng PaymentStatus (nếu cần)
}
