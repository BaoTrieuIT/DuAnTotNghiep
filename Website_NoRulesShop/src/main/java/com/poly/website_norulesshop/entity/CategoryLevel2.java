package com.poly.website_norulesshop.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "category_level_2")
public class CategoryLevel2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_level_2_id")
    private Integer category_level_2_id;

    private String category_level_2_name;
    @JsonIgnore
    @OneToMany(mappedBy = "categoryLevel2")
    List<CategoryLevel2Detail> categoryLevel2DetailList;
    // Getters and setters
}