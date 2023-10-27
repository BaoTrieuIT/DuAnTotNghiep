package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.AccountRepository;
import com.poly.website_norulesshop.collection.MyAccountDetails;
import com.poly.website_norulesshop.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new MyAccountDetails(account);
    }
}
