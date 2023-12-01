package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.collection.MyAccountDetails;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;
import com.poly.website_norulesshop.service.GeneralService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service

public class GeneralServiceImpl implements GeneralService {
    private final AccountService accountService;

    public GeneralServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    public Integer usernameHandler(Principal principal) {
        return getUsername(principal);
    }

    public Integer getUsername(Principal principal) {
        String username = principal.getName();
        Account account = accountService.findByUsername(username);
        if (account == null) {
            MyAccountDetails oauthUser = (MyAccountDetails) ((Authentication) principal).getPrincipal();
            String existingEmail = oauthUser.getUsername();
            account = accountService.findByUsername(existingEmail);
        }
        return account.getAccount_id();
    }
}
