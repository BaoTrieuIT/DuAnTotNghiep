package com.poly.website_norulesshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "brand_image")
public class BrandImage {
    @Id
    @Column(name= "brand_image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer brand_image_id;

    private String imag_url;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    // Getters and setters
}
