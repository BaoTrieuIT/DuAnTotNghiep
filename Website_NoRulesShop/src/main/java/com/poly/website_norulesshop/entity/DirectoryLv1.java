package com.poly.website_norulesshop.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "directory_lv1")
public class DirectoryLv1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directory_lv1_id")
    private Integer directory_lv1_id;

    private String directory_lv1_name;

    @ManyToOne
    @JoinColumn(name = "directory_id")
    private Directory directory;

    @JsonIgnore
    @OneToMany(mappedBy = "directoryLv1")
    private List<DirectoryLv1Brand> directoryLv1ImageList;

    @JsonIgnore
    @OneToMany(mappedBy = "directoryLv1")
    private List<InformationType> informationTypeList;

    @JsonIgnore
    @OneToMany(mappedBy = "directoryLv1")
    private List<Product> productList;
}