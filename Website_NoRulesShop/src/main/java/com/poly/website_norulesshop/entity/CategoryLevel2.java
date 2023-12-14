package com.poly.website_norulesshop.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "category_level_2")
public class CategoryLevel2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_level_2_id")
    private Integer category_level_2_id;

    private String category_level_2_name;
    @JsonIgnore
    @OneToMany(mappedBy = "categoryLevel2", fetch = FetchType.LAZY)
    List<CategoryLevel2Detail> categoryLevel2DetailList;
    // Getters and setters
}
