package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "payment_status")
public class PaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_status_id")
    private Integer payment_status_id;

    private String payment_status_name;

    // Getters and setters

    @OneToMany(mappedBy = "paymentStatus")
    List<Order> orderList;
}
