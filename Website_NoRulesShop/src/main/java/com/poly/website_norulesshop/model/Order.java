package com.poly.website_norulesshop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer order_id;

    private Date order_time;
    private Integer discount_amout;
    private String recipient_name;
    private String phonenumber;
    private String specified_address;
    private String order_note;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "payment_status_id")
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod  paymentMethod;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetailList;
    // Getters and setters
}
