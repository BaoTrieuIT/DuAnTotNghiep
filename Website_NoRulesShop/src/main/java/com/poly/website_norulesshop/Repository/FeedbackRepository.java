package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // Các phương thức đặc thù cho bảng Feedback (nếu cần)
}
