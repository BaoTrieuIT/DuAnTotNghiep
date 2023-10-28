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
@Table(name = "information_type")
public class InformationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_type_id")
    private Integer informationTypeId;

    @Column(name = "information_type_name")
    private String informationTypeName;



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
    @OneToMany(mappedBy = "informationType")
    private List<ProductInformationType> informationTypeList;

    // Getters and setters
}
