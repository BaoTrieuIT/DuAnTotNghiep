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
@Table(name = "directory")
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directory_id")
    private Integer directoryId;
    @Column(name = "directory_name")
    private String directoryName;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @JsonIgnore
    @OneToMany(mappedBy = "directory")
    private List<DirectoryLv1> directoryLv1List;

    // Getters and setters
}
