package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String recipient_name;

    private String recipient_phone_number;

    private String general_address;
    private String specific_address;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Getters and setters
}
