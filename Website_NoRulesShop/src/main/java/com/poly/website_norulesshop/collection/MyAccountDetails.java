package com.poly.website_norulesshop.collection;

import com.poly.website_norulesshop.model.Account;
import com.poly.website_norulesshop.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyAccountDetails implements UserDetails {
    private final Account account;
    private Role role;

    public MyAccountDetails(Account account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = account.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return this.account.getFullname();
    }

    public String getPhoneNumber() {
        return this.account.getPhone_number();
    }

    public String getEmail() {
        return this.account.getEmail();
    }

    public Date getBirthday() {
        return this.account.getBirthday();
    }

    public String getAvatar() {
        return this.account.getAvatar_url();
    }

    public boolean hasRole(String roleName) {
        return account.hasRole(roleName);
    }
}
