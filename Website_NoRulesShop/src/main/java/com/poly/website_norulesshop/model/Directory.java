package com.poly.website_norulesshop.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "directory")
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directory_id")
    private Integer directory_id;

    private String directory_name;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    Gender gender;

    @JsonIgnore
    @OneToMany(mappedBy = "directory")
    private List<DirectoryLv1> directoryLv1List;

    // Getters and setters
}
