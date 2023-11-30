package com.poly.website_norulesshop.service;

import java.util.List;

import com.poly.website_norulesshop.dto.AccountDTO;
import com.poly.website_norulesshop.entity.Account;

public interface AccountService {
    Account saveAccount(Account account);

    void saveAccount(AccountDTO accountDTO);

    Account getAccountById(Integer id);

    Account findByUsername(String username);

    List<Account> getAllAccounts();

    void deleteAccount(Integer id);

    Account findByEmail(String email);

    Account update(Account account);

    Account resetPassword(String email, String newPassword);

    void updateAccount_frUser(Account account, String newPassword);
}
