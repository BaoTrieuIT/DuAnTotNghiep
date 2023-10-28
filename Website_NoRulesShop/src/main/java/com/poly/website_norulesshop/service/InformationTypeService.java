package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.InformationType;

import java.util.List;

public interface InformationTypeService {
    InformationType saveInformationType(InformationType informationType);

    InformationType getInformationTypeById(Long id);

    List<InformationType> getAllInformationTypes();

    void deleteInformationType(Long id);
}
