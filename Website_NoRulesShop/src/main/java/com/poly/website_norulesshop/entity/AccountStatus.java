package com.poly.website_norulesshop.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_status_id")
    private Integer accountStatusId;
    @Column(name = "account_status_name", nullable = false, length = 50)
    private String accountStatusName;

    @OneToMany(mappedBy = "accountStatus")
    public List<Account> accountList;

}
