package com.poly.website_norulesshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_infromation_type")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProductInformationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_infromation_type_id")
    private Integer productInformationTypeId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "information_type_id")
    private InformationType information_type;

    @Column(name = "infromation_type_value", length = 10000)
    private String informationTypeValue;

    // Getters and setters

}
