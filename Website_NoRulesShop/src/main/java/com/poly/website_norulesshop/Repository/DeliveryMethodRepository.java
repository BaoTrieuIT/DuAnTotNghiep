package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.DeliveryMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryMethodRepository extends JpaRepository<DeliveryMethod, Long> {
    // Các phương thức đặc thù cho bảng DeliveryMethod (nếu cần)
}
