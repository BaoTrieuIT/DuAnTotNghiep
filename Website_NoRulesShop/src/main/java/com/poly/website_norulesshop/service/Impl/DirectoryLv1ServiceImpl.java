package com.poly.website_norulesshop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.DirectoryLv1Repository;
import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.DirectoryLv1;
import com.poly.website_norulesshop.service.DirectoryLv1Service;

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
    public DirectoryLv1 getDirectoryLv1ById(Integer id) {
        return directoryLv1Repository.findById(id).orElse(null);
    }

    @Override
    public List<DirectoryLv1> getAllDirectoryLv1s() {
        return directoryLv1Repository.findAll();
    }

    @Override
    public void deleteDirectoryLv1(Integer id) {
        directoryLv1Repository.deleteById(id);
    }

    @Override
    public List<DirectoryLv1> getByDirectory(Directory directory){
        return directoryLv1Repository.findByDirectory(directory);
    }

    @Override
    public void deleteDirectories(List<Integer> directoryLv1Ids) {
        for (Integer directoryId : directoryLv1Ids) {
            directoryLv1Repository.deleteById(directoryId);
        }
    }
}
