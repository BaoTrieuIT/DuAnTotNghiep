package com.poly.website_norulesshop.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table (name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer role_id;

    @Column(name = "role_name", nullable = false, length = 50)
    private String role_name;

    @OneToMany(mappedBy = "role")
    public List<Account> accountList;
}