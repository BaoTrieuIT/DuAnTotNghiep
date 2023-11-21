package com.poly.website_norulesshop.entity;
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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "recipient_phone_number")
    private String recipientPhoneNumber;

    @Column(name = "general_address")
    private String generalAddress;

    @Column(name = "specific_address")
    private String specificAddress;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Getters and setters
}
