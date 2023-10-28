package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    // Các phương thức đặc thù cho bảng PaymentMethod (nếu cần)
}
