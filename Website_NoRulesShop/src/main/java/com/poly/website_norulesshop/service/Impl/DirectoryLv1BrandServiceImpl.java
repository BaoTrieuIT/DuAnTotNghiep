package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.DirectoryLv1BrandRepository;
import com.poly.website_norulesshop.entity.DirectoryLv1Brand;
import com.poly.website_norulesshop.service.DirectoryLv1BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryLv1BrandServiceImpl implements DirectoryLv1BrandService {

    private final DirectoryLv1BrandRepository directoryLv1BrandRepository;

    @Autowired
    public DirectoryLv1BrandServiceImpl(DirectoryLv1BrandRepository directoryLv1BrandRepository) {
        this.directoryLv1BrandRepository = directoryLv1BrandRepository;
    }

    public DirectoryLv1Brand saveDirectoryLv1(DirectoryLv1Brand directoryLv1Brand) {
        return this.directoryLv1BrandRepository.save(directoryLv1Brand);
    }

    @Override
    public DirectoryLv1Brand saveDirectoryLv1Brand(DirectoryLv1Brand directoryLv1Brand) {
        return null;
    }

    @Override
    public DirectoryLv1Brand getDirectoryLv1BrandById(Integer id) {
        return directoryLv1BrandRepository.findById(id).orElse(null);
    }

    @Override
    public List<DirectoryLv1Brand> getAllDirectoryLv1Brands() {
        return directoryLv1BrandRepository.findAll();
    }

    @Override
    public void deleteDirectoryLv1Brand(Integer id) {
        directoryLv1BrandRepository.deleteById(id);
    }
}
