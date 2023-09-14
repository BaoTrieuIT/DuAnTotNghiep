package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.FeedbackReport;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeedbackReportService {
    FeedbackReport saveFeedbackReport(FeedbackReport feedbackReport);

    FeedbackReport getFeedbackReportById(Long id);

    List<FeedbackReport> getAllFeedbackReports();

    void deleteFeedbackReport(Long id);
}
