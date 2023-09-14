package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "feedback_report")
public class FeedbackReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_report_id")
    private Integer feedback_report_id;

    private Date report_date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "report_status_id")
    private ReportStatus reportStatus;

    // Getters and setters
}
