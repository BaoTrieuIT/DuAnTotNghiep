package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.DirectoryLv2;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DirectoryLv2Service {
    DirectoryLv2 saveDirectoryLv2(DirectoryLv2 directoryLv2);

    DirectoryLv2 getDirectoryLv2ById(Long id);

    List<DirectoryLv2> getAllDirectoryLv2s();

    void deleteDirectoryLv2(Long id);
}
