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
@Table(name = "category_level_2")
public class CategoryLevel2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_level_2_id")
    private Integer categoryLevel2Id;

    @Column(name = "category_level_2_name")
    private String categoryLevel2Name;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryLevel2")
    private List<CategoryLevel2Detail> categoryLevel2DetailList;

    // Getters and setters
}
