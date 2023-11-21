package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.AddressRepository;
import com.poly.website_norulesshop.entity.Account;
import com.poly.website_norulesshop.entity.Address;
import com.poly.website_norulesshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Optional<Address> getAddressByAccountId(Account accountId) {
        return addressRepository.findAddressByAccount(accountId);
    }

}
