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
@Table(name = "directory_lv1")
public class DirectoryLv1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directory_lv1_id")
    private Integer directoryLv1Id;

    @Column(name = "directory_lv1_name")
    private String directoryLv1Name;

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
