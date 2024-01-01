package com.poly.website_norulesshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.website_norulesshop.entity.FeedbackImage;

@Repository
public interface FeedbackImageRepository extends JpaRepository<FeedbackImage, Integer> {
    // Các phương thức đặc thù cho bảng FeedbackImage (nếu cần)
}
