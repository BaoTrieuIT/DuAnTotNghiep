package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.Directory;
import com.poly.website_norulesshop.model.DirectoryLv1;
import com.poly.website_norulesshop.model.Gender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DirectoryLv1Service {
    DirectoryLv1 saveDirectoryLv1(DirectoryLv1 directoryLv1);

    DirectoryLv1 getDirectoryLv1ById(Integer id);

    List<DirectoryLv1> getAllDirectoryLv1s();

    void deleteDirectoryLv1(Integer id);

    List<DirectoryLv1> getByDirectory(Directory directory);
}
