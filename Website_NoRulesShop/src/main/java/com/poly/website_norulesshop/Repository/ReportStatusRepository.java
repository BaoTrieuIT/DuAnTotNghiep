package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.ReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportStatusRepository extends JpaRepository<ReportStatus, Long> {
    // Các phương thức đặc thù cho bảng ReportStatus (nếu cần)
}
