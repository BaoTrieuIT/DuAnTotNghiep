package com.poly.website_norulesshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

    @Column(name = "another_information")
    private String anotherInformation;

    @Column(name = "is_excepted")
    private Boolean isExcepted;

    @ManyToOne
    @JoinColumn(name = "directory_lv1_id")
    private DirectoryLv1 directoryLv1;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<BrandImage> brandImageList;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<Product> productList;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<DirectoryLv1Brand> directoryLv1ImageList;

    // Getters and setters
}
