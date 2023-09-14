package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.DirectoryLv2Repository;
import com.poly.website_norulesshop.model.DirectoryLv2;
import com.poly.website_norulesshop.service.DirectoryLv2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryLv2ServiceImpl implements DirectoryLv2Service {

    private final DirectoryLv2Repository directoryLv2Repository;

    @Autowired
    public DirectoryLv2ServiceImpl(DirectoryLv2Repository directoryLv2Repository) {
        this.directoryLv2Repository = directoryLv2Repository;
    }

    @Override
    public DirectoryLv2 saveDirectoryLv2(DirectoryLv2 directoryLv2) {
        return directoryLv2Repository.save(directoryLv2);
    }

    @Override
    public DirectoryLv2 getDirectoryLv2ById(Long id) {
        return directoryLv2Repository.findById(id).orElse(null);
    }

    @Override
    public List<DirectoryLv2> getAllDirectoryLv2s() {
        return directoryLv2Repository.findAll();
    }

    @Override
    public void deleteDirectoryLv2(Long id) {
        directoryLv2Repository.deleteById(id);
    }
}
