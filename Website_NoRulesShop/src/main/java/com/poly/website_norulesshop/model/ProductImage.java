package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Integer product_image_id;
    private String image_url;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and setters
}
