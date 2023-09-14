package com.poly.website_norulesshop.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
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
