package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.DetailInformationTypeRepository;
import com.poly.website_norulesshop.model.DetailInformationType;
import com.poly.website_norulesshop.model.InformationType;
import com.poly.website_norulesshop.service.DetailInformationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("detailInformationTypeService")
public class DetailInformationTypeServiceImpl implements DetailInformationTypeService {

    private final DetailInformationTypeRepository detailInformationTypeRepository;

    @Autowired
    public DetailInformationTypeServiceImpl(DetailInformationTypeRepository detailInformationTypeRepository) {
        this.detailInformationTypeRepository = detailInformationTypeRepository;
    }

    @Override
    public DetailInformationType saveDetailInformationType(DetailInformationType detailInformationType) {
        return detailInformationTypeRepository.save(detailInformationType);
    }

    @Override
    public DetailInformationType getDetailInformationTypeById(Long id) {
        return detailInformationTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetailInformationType> getAllDetailInformationTypes() {
        return detailInformationTypeRepository.findAll();
    }

    @Override
    public void deleteDetailInformationType(Long id) {
        detailInformationTypeRepository.deleteById(id);
    }

    @Override
    public List<DetailInformationType> getByInfomationType(InformationType informationType) {
        return detailInformationTypeRepository.findByInformationType(informationType);
    }
}
