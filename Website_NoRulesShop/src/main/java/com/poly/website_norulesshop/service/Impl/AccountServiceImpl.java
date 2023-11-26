package com.poly.website_norulesshop.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import com.poly.website_norulesshop.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.AccountRepository;
import com.poly.website_norulesshop.Repository.RoleRepository;
import com.poly.website_norulesshop.dto.AccountDTO;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void saveAccount(AccountDTO accountDTO) {
        Date currentDate = new Date(System.currentTimeMillis());
        Account account = new Account();
        // encrypt the password once we integrate spring security
        // user.setPassword(UserDTO.getPassword());
        account.setUsername(accountDTO.getUsername());
        account.setEmail(accountDTO.getEmail());
        account.setCreate_date(currentDate);
        account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));

        Role role = roleRepository.findRoleByRole_name("USER");
        if (role == null) {
            role = checkRoleExist();
        }
        account.setRoles(Set.of(role));
        accountRepository.save(account);
    }

    private AccountDTO convertEntityToDto(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername(account.getUsername());
        System.out.println(account.getUsername());
        return accountDTO;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setRole_name("USER");
        return roleRepository.save(role);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account update(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public Account resetPassword(String email, String newPassword) {
        return Optional.ofNullable(findByEmail(email))
                .map(users -> {
                    users.setPassword(passwordEncoder.encode(newPassword));
                    return accountRepository.save(users);
                }).orElse(null);
    }

    @Override
    public void updateAccount_frUser(Account updatedAccount) {
        // Lấy tài khoản từ session
        Optional<Account> existingAccountOptional = accountRepository
                .findById(updatedAccount.getAccount_id().longValue());

        // Kiểm tra xem tài khoản trong session có phù hợp với account_id hay không
        if (existingAccountOptional.isPresent()) {
            Account existingAccount = existingAccountOptional.get();

            // Check if the existing account's account_id matches the updatedAccount's
            // account_id
            if (existingAccount.getAccount_id().equals(updatedAccount.getAccount_id())) {
                // Cập nhật thông tin tài khoản
                existingAccount.setUsername(updatedAccount.getUsername());
                existingAccount.setFullname(updatedAccount.getFullname());
                existingAccount.setAvatar_url(updatedAccount.getAvatar_url());
                existingAccount.setPassword(passwordEncoder.encode(updatedAccount.getPassword()));
                existingAccount.setEmail(updatedAccount.getEmail());
                existingAccount.setPhone_number(updatedAccount.getPhone_number());
                existingAccount.setBirthday(updatedAccount.getBirthday());
                existingAccount.setAddress(updatedAccount.getAddress());
                // Lưu tài khoản đã cập nhật vào cơ sở dữ liệu (nếu cần)
                accountRepository.save(existingAccount);
            } else {
                // Handle the case where account_id does not match
            }
        } else {
            // Handle the case where no account with the provided account_id is found
        }
    }

}
