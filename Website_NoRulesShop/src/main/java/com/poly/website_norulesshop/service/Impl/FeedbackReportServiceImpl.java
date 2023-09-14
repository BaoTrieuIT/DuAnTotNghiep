package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.FeedbackReportRepository;
import com.poly.website_norulesshop.model.FeedbackReport;
import com.poly.website_norulesshop.service.FeedbackReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackReportServiceImpl implements FeedbackReportService {

    private final FeedbackReportRepository feedbackReportRepository;

    @Autowired
    public FeedbackReportServiceImpl(FeedbackReportRepository feedbackReportRepository) {
        this.feedbackReportRepository = feedbackReportRepository;
    }

    @Override
    public FeedbackReport saveFeedbackReport(FeedbackReport feedbackReport) {
        return feedbackReportRepository.save(feedbackReport);
    }

    @Override
    public FeedbackReport getFeedbackReportById(Long id) {
        return feedbackReportRepository.findById(id).orElse(null);
    }

    @Override
    public List<FeedbackReport> getAllFeedbackReports() {
        return feedbackReportRepository.findAll();
    }

    @Override
    public void deleteFeedbackReport(Long id) {
        feedbackReportRepository.deleteById(id);
    }
}
