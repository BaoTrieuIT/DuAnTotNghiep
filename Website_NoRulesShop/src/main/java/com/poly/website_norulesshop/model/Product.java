package com.poly.website_norulesshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


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
