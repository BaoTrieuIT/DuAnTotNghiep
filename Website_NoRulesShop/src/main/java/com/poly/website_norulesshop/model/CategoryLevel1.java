package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "category_level_1")
public class CategoryLevel1 {
    @Id
    @Column(name = "category_level_1_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_level_1_id;

    private String category_level_1_name;

    @OneToMany(mappedBy = "categoryLevel1")
    List<CategoryLevel1Detail> categoryLevel1DetailList;
    // Getters and setters
}
