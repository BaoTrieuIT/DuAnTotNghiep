package com.poly.website_norulesshop.entity;

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
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_rating")
    private Float productRating = 5.0F;


    @Column(name = "is_remove")
    private Boolean isRemoved = false;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "price_new")
    private Double priceNew;

    @Column(name = "price_old")
    private Double priceOld;


    @Column(name = "discount")
    private Double discount;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "directory_lv1_id")
    private DirectoryLv1 directoryLv1;

    @JsonIgnore
    // Getters and setters
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    List<CategoryQuantity> categoryQuantityList;
    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    List<OrderDetail> orderDetailList;
    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProductImage> productImageList;


}
