package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.DetailInformationType;
import com.poly.website_norulesshop.model.InformationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailInformationTypeRepository extends JpaRepository<DetailInformationType, Long> {
    // Các phương thức đặc thù cho bảng DetailInformationType (nếu cần)
    List<DetailInformationType> findByInformationType(InformationType informationType);
}
