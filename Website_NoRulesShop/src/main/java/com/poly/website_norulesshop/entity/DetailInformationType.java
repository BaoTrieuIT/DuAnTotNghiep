package com.poly.website_norulesshop.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "detail_information_type")
public class DetailInformationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_information_type_id")
    private Integer detail_information_type_id;

    private String detail_Information_type_name;

    @ManyToOne
    @JoinColumn(name = "information_type_id")
    private InformationType informationType;

    // Getters and setters
}
