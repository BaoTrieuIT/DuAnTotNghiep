package com.poly.website_norulesshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_discount")
public class ProductDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_discount_id")
    private Integer productDiscountId;

    @Column(name = "product_discount_name")
    private String productDiscountName;

    @Column(name = "product_discount_valid_from")
    private Date productDiscountValidFrom;

    @Column(name = "product_discount_valid_to")
    private Date productDiscountValidTo;

    @Column(name = "product_discount_value")
    private Float productDiscountValue;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "product_discount_description")
    private String productDiscountDescription;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and setters
}
