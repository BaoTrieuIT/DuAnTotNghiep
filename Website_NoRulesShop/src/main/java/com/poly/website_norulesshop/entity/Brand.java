package com.poly.website_norulesshop.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "brand")
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "website_url")
    private String websiteUrl;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "another_information")
    private String anotherInformation;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<BrandImage> brandImageList;
    // Getters and setters

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<Product> productList;

    // Getters and setters
}
