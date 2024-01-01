package com.poly.website_norulesshop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.FeedbackImageRepository;
import com.poly.website_norulesshop.entity.FeedbackImage;
import com.poly.website_norulesshop.service.FeedbackImageService;

@Service
public class FeedbackImageServiceImpl implements FeedbackImageService {

    private final FeedbackImageRepository feedbackImageRepository;

    @Autowired
    public FeedbackImageServiceImpl(FeedbackImageRepository feedbackImageRepository) {
        this.feedbackImageRepository = feedbackImageRepository;
    }

    @Override
    public FeedbackImage saveFeedbackImage(FeedbackImage feedbackImage) {
        return feedbackImageRepository.save(feedbackImage);
    }

    @Override
    public FeedbackImage getFeedbackImageById(Integer id) {
        return feedbackImageRepository.findById(id).orElse(null);
    }

    @Override
    public List<FeedbackImage> getAllFeedbackImages() {
        return feedbackImageRepository.findAll();
    }

    @Override
    public void deleteFeedbackImage(Integer id) {
        feedbackImageRepository.deleteById(id);
    }
}
