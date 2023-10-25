package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "product_discount")
public class ProductDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_discount_id")
    private Integer product_discount_id;
    private String product_discount_name;
    private Date product_discount_valid_from;
    private Date product_discount_valid_to;
    private Float product_discount_value;
    private Integer quantity;
    private String product_discount_description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and setters
}
