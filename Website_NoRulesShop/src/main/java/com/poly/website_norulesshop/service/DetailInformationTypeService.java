package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.DetailInformationType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DetailInformationTypeService {
    DetailInformationType saveDetailInformationType(DetailInformationType detailInformationType);

    DetailInformationType getDetailInformationTypeById(Long id);

    List<DetailInformationType> getAllDetailInformationTypes();

    void deleteDetailInformationType(Long id);
}
