package com.poly.website_norulesshop.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @Column(name = "account_id")
    private Integer account_id;
    @NotBlank(message = "Vui lòng nhập mật khẩu")
    private String password;
    @NotBlank(message = "Vui lòng nhập họ tên")
    private String fullname;
    @NotBlank(message = "Vui lòng nhập số điên thoại")
    private String phone_number;
    @NotBlank(message = "Vui lòng nhập email")
    @Email(message = "Vui lòng nhập đúng định dạng")
    private String email;
    @NotBlank(message = "Vui lòng nhập tên tài khoản")
    private String username;

    private Date create_date;

    private Date birthday;

    private String avatar_url;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "accounts_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", columnDefinition = "bit default 1")
    )
    private Set<Role> roles = new HashSet<>();

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
