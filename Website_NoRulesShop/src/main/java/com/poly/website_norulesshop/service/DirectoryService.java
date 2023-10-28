package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Directory;
import com.poly.website_norulesshop.entity.Gender;

import java.util.List;

public interface DirectoryService {
    Directory saveDirectory(Directory directory);

    Directory getDirectoryById(Integer id);

    List<Directory> getAllDirectories();

    void deleteDirectory(Integer id);
    List<Directory> getByGender(Gender gender);
}
