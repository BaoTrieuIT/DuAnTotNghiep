package com.poly.website_norulesshop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "information_type")
public class InformationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "information_type_id")
    private Integer information_type_id;

    private String information_type_name;

    @ManyToOne
    @JoinColumn(name = "directory_id")
    private Directory directory;
    @JsonIgnore
    @OneToMany(mappedBy = "informationType")
    List<DetailInformationType> detailInformationTypeList;
    @JsonIgnore
    @OneToMany(mappedBy = "information_type")
    List<ProductInformationType> informationTypeList;
}
