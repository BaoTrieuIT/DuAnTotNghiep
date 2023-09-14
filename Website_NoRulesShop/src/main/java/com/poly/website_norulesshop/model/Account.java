package com.poly.website_norulesshop.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "ranked_id")
    private Ranked ranked;

    @ManyToOne
    @JoinColumn(name = "account_status_id")
    private AccountStatus accountStatus;

    @OneToMany(mappedBy = "account")
    public List<Address> addressList;

    @OneToMany(mappedBy = "account")
    public List<Feedback> feedbackList;
    @OneToMany(mappedBy = "account")
    public List<FeedbackReport> feedbackReportList;
    @OneToMany(mappedBy = "account")
    public List<Order> orderList;

    @OneToMany(mappedBy = "account")
    List<Points> pointsList;


}
