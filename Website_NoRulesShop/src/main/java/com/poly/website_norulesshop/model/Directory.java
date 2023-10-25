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
@Table(name = "directory")
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directory_id")
    private Integer directory_id;

    private String directory_name;

    @JsonIgnore
    @OneToMany(mappedBy = "directory")
    List<DirectoryLv1> directoryLv1List;
    @JsonIgnore
    @OneToMany(mappedBy = "directory")
    List<InformationType> informationTypes;
    // Getters and setters
}
