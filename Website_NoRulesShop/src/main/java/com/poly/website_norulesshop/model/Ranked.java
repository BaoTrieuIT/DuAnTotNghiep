package com.poly.website_norulesshop.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ranked")
public class Ranked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranked_id")
    private Integer ranked_id;

    private String rank_name;
    private Integer minimum_point;

    @OneToMany(mappedBy = "ranked")
    public List<Account> accountList;
}