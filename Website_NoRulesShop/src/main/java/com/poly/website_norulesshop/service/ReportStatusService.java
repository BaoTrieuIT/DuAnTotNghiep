package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.ReportStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReportStatusService {
    ReportStatus saveReportStatus(ReportStatus reportStatus);

    ReportStatus getReportStatusById(Long id);

    List<ReportStatus> getAllReportStatuses();

    void deleteReportStatus(Long id);
}
