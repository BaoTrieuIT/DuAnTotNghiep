package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.FeedbackImage;
@Service
public interface FeedbackImageService {
    FeedbackImage saveFeedbackImage(FeedbackImage feedbackImage);

    FeedbackImage getFeedbackImageById(Integer id);

    List<FeedbackImage> getAllFeedbackImages();

    void deleteFeedbackImage(Integer id);
}
