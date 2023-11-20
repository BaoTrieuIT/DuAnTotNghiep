package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.InformationType;
import com.poly.website_norulesshop.model.DetailInformationType;
@Service
public interface DetailInformationTypeService {
    DetailInformationType saveDetailInformationType(DetailInformationType detailInformationType);

    DetailInformationType getDetailInformationTypeById(Long id);

    List<DetailInformationType> getAllDetailInformationTypes();

    void deleteDetailInformationType(Long id);

    List<DetailInformationType> getByInfomationType(InformationType informationType);
}
