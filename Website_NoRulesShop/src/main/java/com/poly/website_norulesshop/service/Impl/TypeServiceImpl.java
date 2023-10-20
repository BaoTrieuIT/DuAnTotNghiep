package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.TypeRepository;
import com.poly.website_norulesshop.model.Type;
import com.poly.website_norulesshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getTypeById(Integer id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public void deleteType(Integer id) {
        typeRepository.deleteById(id);
    }
}
