package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.Directory;
import com.poly.website_norulesshop.model.Gender;

import java.util.List;

public interface DirectoryService {
    Directory saveDirectory(Directory directory);

    Directory getDirectoryById(Long id);

    List<Directory> getAllDirectories();

    void deleteDirectory(Long id);
    List<Directory> getByGender(Gender gender);
}
