package com.poly.website_norulesshop.Repository;

import com.poly.website_norulesshop.model.FeedbackImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackImageRepository extends JpaRepository<FeedbackImage, Long> {
    // Các phương thức đặc thù cho bảng FeedbackImage (nếu cần)
}
