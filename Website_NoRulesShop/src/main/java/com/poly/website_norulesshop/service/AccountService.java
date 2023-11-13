package com.poly.website_norulesshop.service;

import java.util.List;

import com.poly.website_norulesshop.dto.AccountDTO;
import com.poly.website_norulesshop.entity.Account;

public interface AccountService {
    Account saveAccount(Account account);

    void saveAccount(AccountDTO accountDTO);


    Account getAccountById(Long id);

    Account findByUsername(String username);

    List<Account> getAllAccounts();

    void deleteAccount(Long id);

    Account findByEmail(String email);
Account update (Account account);
    Account resetPassword(String email, String newPassword);

}