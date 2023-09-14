package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.AccountStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountStatusService {
    AccountStatus saveAccountStatus(AccountStatus accountStatus);

    AccountStatus getAccountStatusById(Integer id);

    List<AccountStatus> getAllAccountStatuses();

    void deleteAccountStatus(Integer id);
}
