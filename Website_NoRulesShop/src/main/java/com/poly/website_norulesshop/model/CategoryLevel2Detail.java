package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "category_level_2_detail")
public class CategoryLevel2Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_level_2_detail_id")
    private Integer category_level_2_detail_id;

    private String category_level_2_detail_name;

    @ManyToOne
    @JoinColumn(name = "category_level_2_id")
    private CategoryLevel2 categoryLevel2;



    // Getters and setters
}
