package com.poly.website_norulesshop.Repository;

import java.util.List;

import com.poly.website_norulesshop.entity.DirectoryLv1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.InformationType;

@Repository
public interface InformationTypeRepository extends JpaRepository<InformationType, Long> {
    // Các phương thức đặc thù cho bảng InformationType (nếu cần)
    List<InformationType> findByDirectoryLv1(DirectoryLv1 directoryLv1);
}
