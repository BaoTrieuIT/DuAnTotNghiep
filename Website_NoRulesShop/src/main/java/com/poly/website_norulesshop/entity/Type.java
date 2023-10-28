package com.poly.website_norulesshop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "type")
public class Type {
    @Id
    @Column(name = "type_id")
    Integer typeId;

    @Column(name = "type_name")
    String typeName;

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    List<InformationType>  informationTypeList;
}
