package com.poly.website_norulesshop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

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

    private String password;
    private String fullname;
    private String phone_number;
    private String email;
    private String username;
    private Date create_date;
    private Date birthday;
    private String avatar_url;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "accounts_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
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

    public boolean hasRole(String roleName){
        Iterator<Role> iterator  = roles.iterator();
        while  (iterator.hasNext()){
            Role role = iterator.next();
            if(role.getRole_name().equals(roleName)){
                return true;
            }

        }
        return false;
    }

}
