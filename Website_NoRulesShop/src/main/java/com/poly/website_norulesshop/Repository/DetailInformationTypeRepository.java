package com.poly.website_norulesshop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.InformationType;
import com.poly.website_norulesshop.model.DetailInformationType;

@Repository
public interface DetailInformationTypeRepository extends JpaRepository<DetailInformationType, Long> {
    // Các phương thức đặc thù cho bảng DetailInformationType (nếu cần)
    List<DetailInformationType> findByInformationType(InformationType informationType);
}
