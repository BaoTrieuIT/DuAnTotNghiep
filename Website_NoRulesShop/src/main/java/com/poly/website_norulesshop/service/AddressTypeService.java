package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.AddressType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AddressTypeService {
    AddressType saveAddressType(AddressType addressType);

    AddressType getAddressTypeById(Long id);

    List<AddressType> getAllAddressTypes();

    void deleteAddressType(Long id);
}
