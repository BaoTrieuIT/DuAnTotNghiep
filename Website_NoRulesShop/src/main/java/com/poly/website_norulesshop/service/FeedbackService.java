package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.Feedback;
@Service
public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);

    Feedback getFeedbackById(Integer id);

    List<Feedback> getAllFeedbacks();

    void deleteFeedback(Integer id);
}
