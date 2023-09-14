package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.DirectoryLv3;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DirectoryLv3Service {
    DirectoryLv3 saveDirectoryLv3(DirectoryLv3 directoryLv3);

    DirectoryLv3 getDirectoryLv3ById(Long id);

    List<DirectoryLv3> getAllDirectoryLv3s();

    void deleteDirectoryLv3(Long id);
}
