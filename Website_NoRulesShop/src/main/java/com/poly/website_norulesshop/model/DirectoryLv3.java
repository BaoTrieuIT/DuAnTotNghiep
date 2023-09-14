package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "directory_lv3")
public class DirectoryLv3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directory_lv3_id")
    private Integer directory_lv3_id;

    private String directory_lv3_name;

    @ManyToOne
    @JoinColumn(name = "directory_lv2_id")
    private DirectoryLv2 directoryLv2;

    // Getters and setters
}
