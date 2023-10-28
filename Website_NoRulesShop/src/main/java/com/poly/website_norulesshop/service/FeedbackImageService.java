package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.FeedbackImage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeedbackImageService {
    FeedbackImage saveFeedbackImage(FeedbackImage feedbackImage);

    FeedbackImage getFeedbackImageById(Long id);

    List<FeedbackImage> getAllFeedbackImages();

    void deleteFeedbackImage(Long id);
}
