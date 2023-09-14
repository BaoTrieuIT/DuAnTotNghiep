package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Các phương thức đặc thù cho bảng Address (nếu cần)
}
