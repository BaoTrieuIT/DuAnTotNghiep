package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);

    Feedback getFeedbackById(Long id);

    List<Feedback> getAllFeedbacks();

    void deleteFeedback(Long id);
}
