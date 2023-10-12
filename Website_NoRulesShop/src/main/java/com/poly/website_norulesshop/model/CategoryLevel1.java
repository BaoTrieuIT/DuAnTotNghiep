package com.poly.website_norulesshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category_level_1")
public class CategoryLevel1 {
    @Id
    @Column(name = "category_level_1_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryLevel1Id;

    @Column(name = "category_level_1_name")
    private String categoryLevel1Name;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryLevel1")
    private List<CategoryLevel1Detail> categoryLevel1DetailList;

    // Getters and setters
}
