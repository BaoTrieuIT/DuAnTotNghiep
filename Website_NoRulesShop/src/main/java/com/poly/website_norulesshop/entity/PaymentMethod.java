package com.poly.website_norulesshop.entity;

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
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id")
    private Integer paymentMethodId;

    @Column(name = "payment_method_name")
    private String paymentMethodName;

    @JsonIgnore
    @OneToMany(mappedBy = "paymentMethod")
    private List<Order> orderList;

    // Getters and setters
}
