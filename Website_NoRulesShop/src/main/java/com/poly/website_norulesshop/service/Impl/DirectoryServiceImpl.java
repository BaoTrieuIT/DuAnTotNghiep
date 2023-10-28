package com.poly.website_norulesshop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.DirectoryRepository;
import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.Gender;
import com.poly.website_norulesshop.service.DirectoryService;

@Service
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryServiceImpl(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @Override
    public Directory saveDirectory(Directory directory) {
        return directoryRepository.save(directory);
    }

    @Override
    public Directory getDirectoryById(Integer id) {
        return directoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Directory> getAllDirectories() {
        return directoryRepository.findAll();
    }

    @Override
    public void deleteDirectory(Integer id) {
        directoryRepository.deleteById(id);
    }

    @Override
    public List<Directory> getByGender(Gender gender) {
        return directoryRepository.findByGender(gender);
    }
}
