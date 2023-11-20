package com.poly.website_norulesshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category_quantity")
public class CategoryQuantity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_quantity_id")
    private Integer categoryQuantityId;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_level_1_detail_id")
    private CategoryLevel1Detail categoryLevel1Detail;

    @ManyToOne
    @JoinColumn(name = "category_level_2_detail_id")
    private CategoryLevel2Detail categoryLevel2Detail;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and setters
}
