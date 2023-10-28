package com.poly.website_norulesshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    private String password;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String username;
    private Date createDate;
    private Date birthday;
    private String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "ranked_id")
    private Ranked ranked;

    @ManyToOne
    @JoinColumn(name = "account_status_id")
    private AccountStatus accountStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    public List<Address> addressList;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    public List<Feedback> feedbackList;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    public List<Order> orderList;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Points> pointsList;
}
