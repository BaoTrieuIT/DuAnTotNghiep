package com.poly.website_norulesshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id")
    Integer genderId;
    @Column(name = "gender_name")
    String genderName;

    @JsonIgnore
    @OneToMany(mappedBy = "gender")
    List<Directory> directoryList;
}
