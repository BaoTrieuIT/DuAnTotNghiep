package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "brand")
public class Brand {
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

    @OneToMany(mappedBy = "brand")
    List<BrandImage> brandImageList;
    // Getters and setters


    @OneToMany(mappedBy = "brand")
    List<Product> productList;
}
