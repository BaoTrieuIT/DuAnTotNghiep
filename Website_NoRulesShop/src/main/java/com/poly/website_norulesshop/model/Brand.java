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
    private Integer brand_id;

    private String brand_name;
    private String logo_url;
    private String website_url;
    private String another_information;
    private Boolean is_excepted;

    @ManyToOne
    @JoinColumn(name = "directory_lv1_id")
    private DirectoryLv1 directoryLv1;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<BrandImage> brandImageList;
    // Getters and setters

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<Product> productList;
    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<DirectoryLv1Brand> directoryLv1ImageList;
}
