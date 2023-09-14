package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {
    // Các phương thức đặc thù cho bảng AddressType (nếu cần)
}
