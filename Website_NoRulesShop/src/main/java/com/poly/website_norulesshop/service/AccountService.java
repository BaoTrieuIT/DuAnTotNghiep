package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Account;

import java.util.List;

public interface AccountService {
    Account saveAccount(Account account);

    Account getAccountById(Long id);

    List<Account> getAllAccounts();

    void deleteAccount(Long id);
}
