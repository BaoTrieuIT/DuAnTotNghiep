package com.poly.website_norulesshop.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.poly.website_norulesshop.constant.Provider;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;
    private String password;
    private String fullname;
    private String phone_number;
    private String email;
    private String username;
    private Date create_date;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthday;
    private String avatar_url;
    private String address;
    @Enumerated(EnumType.STRING)
    private Provider provider;
    //    columnDefinition = "bit default 2" , ALL
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "accounts_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "role_id",
                    columnDefinition = "bit default 2"))
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ranked_id")
    private Ranked ranked;
    @ManyToOne
    @JoinColumn(name = "account_status_id")
    private AccountStatus accountStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    public List<Feedback> feedbackList;
    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    public List<Order> orderList;
    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    List<Points> pointsList;

    public boolean hasRole(String roleName) {
        Iterator<Role> iterator = roles.iterator();
        while (iterator.hasNext()) {
            Role role = iterator.next();
            if (role.getRole_name().equals(roleName)) {
                return true;
            }

        }
        return false;
    }

}