package com.poly.website_norulesshop.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_time")
    private Date orderTime = new Date();
    @Column(name = "update_order_time")
    private Date orderUpdateTime;
    @Column(name = "discount_amout")
    private Integer discountAmout;
    @Column(name = "recipient_name")
    private String recipientName;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "specified_address")
    private String specifiedAddress;
    @Column(name = "order_note")
    private String orderNote;
    @Column(name = "trading_code")
    private String tradingCode;
    @Column(name = "total")
    private Integer totalPrice;

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
    private PaymentMethod paymentMethod;
    @Transient  // Mark this field as transient to exclude it from persistence
    private Integer paymentMethodId;

    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<OrderDetail> orderDetailList;
    // Getters and setters
}
