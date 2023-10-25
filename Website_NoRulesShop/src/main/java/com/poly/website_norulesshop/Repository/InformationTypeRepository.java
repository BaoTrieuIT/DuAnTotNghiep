package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.DirectoryLv1;
import com.poly.website_norulesshop.model.InformationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationTypeRepository extends JpaRepository<InformationType, Long> {
    // Các phương thức đặc thù cho bảng InformationType (nếu cần)
    List<InformationType> findByDirectoryLv1(DirectoryLv1 directoryLv1);
}
