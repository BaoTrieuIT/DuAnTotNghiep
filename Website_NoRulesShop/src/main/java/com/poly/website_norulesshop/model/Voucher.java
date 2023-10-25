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
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id")
    private Integer voucher_id;

    private Float voucher_value;
    private String voucher_code;
    private Date valid_from;
    private Date valid_to;
    private Long minimize_order_amount;
    private Integer quantity_available;
    @JsonIgnore
    @OneToMany(mappedBy = "voucher")
    List<Order> orderList;
}
