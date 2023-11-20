package com.poly.website_norulesshop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.InformationType;
import com.poly.website_norulesshop.model.DirectoryLv1;

@Repository
public interface InformationTypeRepository extends JpaRepository<InformationType, Long> {
    // Các phương thức đặc thù cho bảng InformationType (nếu cần)
    List<InformationType> findByDirectoryLv1(DirectoryLv1 directoryLv1);
}
