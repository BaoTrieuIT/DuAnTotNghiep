package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.AccountStatusRepository;
import com.poly.website_norulesshop.entity.AccountStatus;
import com.poly.website_norulesshop.service.AccountStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountStatusServiceImpl implements AccountStatusService {

    private final AccountStatusRepository accountStatusRepository;

    @Autowired
    public AccountStatusServiceImpl(AccountStatusRepository accountStatusRepository) {
        this.accountStatusRepository = accountStatusRepository;
    }

    @Override
    public AccountStatus saveAccountStatus(AccountStatus accountStatus) {
        return accountStatusRepository.save(accountStatus);
    }

    @Override
    public AccountStatus getAccountStatusById(Integer id) {
        return accountStatusRepository.findById(id).orElse(null);
    }

    @Override
    public List<AccountStatus> getAllAccountStatuses() {
        return accountStatusRepository.findAll();
    }

    @Override
    public void deleteAccountStatus(Integer id) {
        accountStatusRepository.deleteById(id);
    }
}
