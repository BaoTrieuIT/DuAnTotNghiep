package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.DirectoryLv3Repository;
import com.poly.website_norulesshop.model.DirectoryLv3;
import com.poly.website_norulesshop.service.DirectoryLv3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryLv3ServiceImpl implements DirectoryLv3Service {

    private final DirectoryLv3Repository directoryLv3Repository;

    @Autowired
    public DirectoryLv3ServiceImpl(DirectoryLv3Repository directoryLv3Repository) {
        this.directoryLv3Repository = directoryLv3Repository;
    }

    @Override
    public DirectoryLv3 saveDirectoryLv3(DirectoryLv3 directoryLv3) {
        return directoryLv3Repository.save(directoryLv3);
    }

    @Override
    public DirectoryLv3 getDirectoryLv3ById(Long id) {
        return directoryLv3Repository.findById(id).orElse(null);
    }

    @Override
    public List<DirectoryLv3> getAllDirectoryLv3s() {
        return directoryLv3Repository.findAll();
    }

    @Override
    public void deleteDirectoryLv3(Long id) {
        directoryLv3Repository.deleteById(id);
    }
}
