package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.DirectoryLv1Repository;
import com.poly.website_norulesshop.entity.DirectoryLv1;
import com.poly.website_norulesshop.service.DirectoryLv1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryLv1ServiceImpl implements DirectoryLv1Service {

    private final DirectoryLv1Repository directoryLv1Repository;

    @Autowired
    public DirectoryLv1ServiceImpl(DirectoryLv1Repository directoryLv1Repository) {
        this.directoryLv1Repository = directoryLv1Repository;
    }

    @Override
    public DirectoryLv1 saveDirectoryLv1(DirectoryLv1 directoryLv1) {
        return directoryLv1Repository.save(directoryLv1);
    }

    @Override
    public DirectoryLv1 getDirectoryLv1ById(Long id) {
        return directoryLv1Repository.findById(id).orElse(null);
    }

    @Override
    public List<DirectoryLv1> getAllDirectoryLv1s() {
        return directoryLv1Repository.findAll();
    }

    @Override
    public void deleteDirectoryLv1(Long id) {
        directoryLv1Repository.deleteById(id);
    }
}
