package com.poly.website_norulesshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ranked")
public class Ranked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranked_id")
    private Integer rankedId;

    @Column(name = "rank_name")
    private String rankName;

    @Column(name = "minimum_point")
    private Integer minimumPoint;

    @JsonIgnore
    @OneToMany(mappedBy = "ranked")
    private List<Account> accountList;

    // Getters and setters
}
