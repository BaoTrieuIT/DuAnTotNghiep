package com.poly.website_norulesshop.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "category_level_1")
public class CategoryLevel1 {
    @Id
    @Column(name = "category_level_1_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_level_1_id;

    private String category_level_1_name;
    @JsonIgnore
    @OneToMany(mappedBy = "categoryLevel1")
    List<CategoryLevel1Detail> categoryLevel1DetailList;
    // Getters and setters
}
