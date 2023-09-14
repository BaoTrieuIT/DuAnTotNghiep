package com.poly.website_norulesshop.model;
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

    @OneToMany(mappedBy = "informationType")
    List<DetailInformationType> detailInformationTypeList;
}
