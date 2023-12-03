package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.AccountRepository;
import com.poly.website_norulesshop.collection.MyAccountDetails;
import com.poly.website_norulesshop.config.GlobalFlag;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account != null && account.getAccountStatus().getAccountStatusId() == 1) {
            GlobalFlag.flag = true;
            return buildUserDetails(account);
        } else {
            GlobalFlag.flag = false;
            throw new UsernameNotFoundException("Invalid username, password or status is false.");
        }
    }

    private UserDetails buildUserDetails(Account account) {
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .authorities(mapRolesToAuthorities(account.getRoles()))
                .build();
        return userDetails;
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        Collection<? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole_name()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}