package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.DetailInformationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailInformationTypeRepository extends JpaRepository<DetailInformationType, Long> {
    // Các phương thức đặc thù cho bảng DetailInformationType (nếu cần)
}
