package com.poly.website_norulesshop.service;

import java.util.List;

import com.poly.website_norulesshop.entity.InformationType;
import com.poly.website_norulesshop.model.DirectoryLv1;

public interface InformationTypeService {
    InformationType saveInformationType(InformationType informationType);

    InformationType getInformationTypeById(Long id);

    List<InformationType> getAllInformationTypes();

    void deleteInformationType(Long id);

    List<InformationType> getByDirectoryLv1(DirectoryLv1 directoryLv1);
}
