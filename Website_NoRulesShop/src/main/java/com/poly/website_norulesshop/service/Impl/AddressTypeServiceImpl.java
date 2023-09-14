package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.AddressTypeRepository;
import com.poly.website_norulesshop.model.AddressType;
import com.poly.website_norulesshop.service.AddressTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressTypeServiceImpl implements AddressTypeService {

    private final AddressTypeRepository addressTypeRepository;

    @Autowired
    public AddressTypeServiceImpl(AddressTypeRepository addressTypeRepository) {
        this.addressTypeRepository = addressTypeRepository;
    }

    @Override
    public AddressType saveAddressType(AddressType addressType) {
        return addressTypeRepository.save(addressType);
    }

    @Override
    public AddressType getAddressTypeById(Long id) {
        return addressTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<AddressType> getAllAddressTypes() {
        return addressTypeRepository.findAll();
    }

    @Override
    public void deleteAddressType(Long id) {
        addressTypeRepository.deleteById(id);
    }
}
