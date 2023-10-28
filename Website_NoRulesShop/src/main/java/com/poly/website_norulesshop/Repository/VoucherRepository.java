package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    // Các phương thức đặc thù cho bảng Voucher (nếu cần)
}
