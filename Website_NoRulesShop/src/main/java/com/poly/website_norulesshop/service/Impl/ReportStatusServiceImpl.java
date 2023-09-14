package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.ReportStatusRepository;
import com.poly.website_norulesshop.model.ReportStatus;
import com.poly.website_norulesshop.service.ReportStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportStatusServiceImpl implements ReportStatusService {

    private final ReportStatusRepository reportStatusRepository;

    @Autowired
    public ReportStatusServiceImpl(ReportStatusRepository reportStatusRepository) {
        this.reportStatusRepository = reportStatusRepository;
    }

    @Override
    public ReportStatus saveReportStatus(ReportStatus reportStatus) {
        return reportStatusRepository.save(reportStatus);
    }

    @Override
    public ReportStatus getReportStatusById(Long id) {
        return reportStatusRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReportStatus> getAllReportStatuses() {
        return reportStatusRepository.findAll();
    }

    @Override
    public void deleteReportStatus(Long id) {
        reportStatusRepository.deleteById(id);
    }
}
