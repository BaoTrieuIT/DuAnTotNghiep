package com.poly.website_norulesshop.entity;

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
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;
    private Integer quantity;
    @Column(name = "discount_amout")
    private Integer discountAmout;
    @Column(name = "total_after_discount")
    private Integer totalPriceNew;
    @Column(name = "total_before_discount")
    private Integer totalPrice;
    @Column(name = "price")
    private Integer price;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "category_quantity_id")
    private CategoryQuantity categoryQuantity;

    @JsonIgnore
    @OneToMany(mappedBy = "orderDetail")
    public List<Feedback> feedbackList;
    // Getters and setters
}
