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
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "discount_amount")
    private Integer discountAmount;

    @Column(name = "total_price_before_discount")
    private Integer totalPriceBeforeDiscount;

    @Column(name = "total_price")
    private Integer totalPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonIgnore
    @OneToMany(mappedBy = "orderDetail")
    private List<Feedback> feedbackList;

    // Getters and setters
}
