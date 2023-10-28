package com.poly.website_norulesshop.service;

import java.util.List;

import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.Gender;

public interface DirectoryService {
    Directory saveDirectory(Directory directory);

    Directory getDirectoryById(Integer id);

    List<Directory> getAllDirectories();

    void deleteDirectory(Integer id);
    List<Directory> getByGender(Gender gender);
}
