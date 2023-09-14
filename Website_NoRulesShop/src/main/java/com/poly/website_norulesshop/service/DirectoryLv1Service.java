package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.DirectoryLv1;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DirectoryLv1Service {
    DirectoryLv1 saveDirectoryLv1(DirectoryLv1 directoryLv1);

    DirectoryLv1 getDirectoryLv1ById(Long id);

    List<DirectoryLv1> getAllDirectoryLv1s();

    void deleteDirectoryLv1(Long id);
}
