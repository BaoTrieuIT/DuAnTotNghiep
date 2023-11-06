package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.dto.AccountDTO;
import com.poly.website_norulesshop.entity.Account;

import java.util.List;

public interface AccountService {
    Account saveAccount(Account account);

    void saveAccount(AccountDTO accountDTO);


    Account getAccountById(Long id);

    Account findByUsername(String username);

    List<Account> getAllAccounts();

    void deleteAccount(Long id);

    Account findByEmail(String email);

    Account resetPassword(String email, String newPassword);

}
