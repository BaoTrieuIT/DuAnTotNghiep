package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AddressService {
    Address saveAddress(Address address);

    Address getAddressById(Long id);

    List<Address> getAllAddresses();

    void deleteAddress(Long id);

    Optional<Address> getAddressByAccountId(Account accountId);
}
