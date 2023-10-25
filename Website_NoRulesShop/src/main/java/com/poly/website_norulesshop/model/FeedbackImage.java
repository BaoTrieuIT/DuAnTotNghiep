package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "feedback_image")
public class FeedbackImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_image_id")
    private Integer feedback_image_id;

    private String image_url;

    @ManyToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    // Getters and setters
}
