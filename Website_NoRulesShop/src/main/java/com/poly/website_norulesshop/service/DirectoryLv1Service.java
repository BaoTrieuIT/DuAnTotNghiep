package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.DirectoryLv1;
@Service
public interface DirectoryLv1Service {
    DirectoryLv1 saveDirectoryLv1(DirectoryLv1 directoryLv1);

    DirectoryLv1 getDirectoryLv1ById(Integer id);

    List<DirectoryLv1> getAllDirectoryLv1s();

    void deleteDirectoryLv1(Integer id);

    List<DirectoryLv1> getByDirectory(Directory directory);

    default void deleteDirectories(List<Integer> directoryLv1Ids){
    };


    List<DirectoryLv1> getByIsActive(Boolean isActive);
}
