package com.poly.website_norulesshop.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer product_id;
    private String product_name;
    private Float product_rating;
    private Date create_date;
    private Boolean is_remove;
    private String product_description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "directory_lv1_id")
    private DirectoryLv1 directoryLv1;

    @JsonIgnore
    // Getters and setters
    @OneToMany(mappedBy = "product")
    List<CategoryQuantity> categoryQuantityList;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetailList;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<ProductDiscount> productDiscounts;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<ProductImage> productImageList;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<ProductInformationType> informationTypeList;
}
