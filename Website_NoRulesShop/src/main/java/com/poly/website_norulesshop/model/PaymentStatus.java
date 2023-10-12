package com.poly.website_norulesshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_status")
public class PaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_status_id")
    private Integer paymentStatusId;

    @Column(name = "payment_status_name")
    private String paymentStatusName;

    @JsonIgnore
    @OneToMany(mappedBy = "paymentStatus")
    private List<Order> orderList;

    // Getters and setters
}
