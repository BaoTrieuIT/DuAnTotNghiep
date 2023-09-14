package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.FeedbackReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackReportRepository extends JpaRepository<FeedbackReport, Long> {
    // Các phương thức đặc thù cho bảng FeedbackReport (nếu cần)
}
