package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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

    // Getters and setters

    @OneToMany(mappedBy = "directoryLv1")
    List<Brand> listBrand;

}
