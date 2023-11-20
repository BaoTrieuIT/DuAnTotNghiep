package com.poly.website_norulesshop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.InformationTypeRepository;
import com.poly.website_norulesshop.entity.InformationType;
import com.poly.website_norulesshop.model.DirectoryLv1;
import com.poly.website_norulesshop.service.InformationTypeService;

@Service
public class InformationTypeServiceImpl implements InformationTypeService {

    private final InformationTypeRepository informationTypeRepository;

    @Autowired
    public InformationTypeServiceImpl(InformationTypeRepository informationTypeRepository) {
        this.informationTypeRepository = informationTypeRepository;
    }

    @Override
    public InformationType saveInformationType(InformationType informationType) {
        return informationTypeRepository.save(informationType);
    }

    @Override
    public InformationType getInformationTypeById(Long id) {
        return informationTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<InformationType> getAllInformationTypes() {
        return informationTypeRepository.findAll();
    }

    @Override
    public void deleteInformationType(Long id) {
        informationTypeRepository.deleteById(id);
    }

    @Override
    public List<InformationType> getByDirectoryLv1(DirectoryLv1 directoryLv1) {
        return informationTypeRepository.findByDirectoryLv1(directoryLv1);
    }
}
