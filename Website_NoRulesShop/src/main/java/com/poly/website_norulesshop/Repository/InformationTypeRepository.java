package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.InformationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationTypeRepository extends JpaRepository<InformationType, Long> {
    // Các phương thức đặc thù cho bảng InformationType (nếu cần)
}
