package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.DirectoryRepository;
import com.poly.website_norulesshop.Repository.GenderRepository;
import com.poly.website_norulesshop.model.Directory;
import com.poly.website_norulesshop.model.Gender;
import com.poly.website_norulesshop.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Directory getDirectoryById(Long id) {
        return directoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Directory> getAllDirectories() {
        return directoryRepository.findAll();
    }

    @Override
    public void deleteDirectory(Long id) {
        directoryRepository.deleteById(id);
    }
}
