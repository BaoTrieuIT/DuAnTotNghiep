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
@Table(name = "information_type")
public class InformationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_type_id")
    private Integer information_type_id;

    private String information_type_name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    Type type;

    @ManyToOne
    @JoinColumn(name = "directory_lv1_id")
    DirectoryLv1 directoryLv1;

    @JsonIgnore
    @OneToMany(mappedBy = "informationType")
    private List<DetailInformationType> detailInformationTypeList;

    @JsonIgnore
    @OneToMany(mappedBy = "information_type")
    private List<ProductInformationType> ProductInformationTypeList;

    // Getters and setters
}
