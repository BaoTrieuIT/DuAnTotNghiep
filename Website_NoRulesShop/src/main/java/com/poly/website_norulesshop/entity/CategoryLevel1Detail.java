package com.poly.website_norulesshop.entity;

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
@Table(name = "category_level_1_detail")
public class CategoryLevel1Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_level_1_detail_id")
    private Integer categoryLevel1DetailId;

    @Column(name = "category_level_1_detail_name")
    private String categoryLevel1DetailName;

    @ManyToOne
    @JoinColumn(name = "category_level_1_id")
    private CategoryLevel1 categoryLevel1;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryLevel1Detail")
    private List<CategoryQuantity> categoryQuantityList;

    // Getters and setters
}
