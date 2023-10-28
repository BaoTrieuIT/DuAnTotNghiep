package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.DirectoryLv1Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DirectoryLv1BrandService {
    DirectoryLv1Brand saveDirectoryLv1Brand(DirectoryLv1Brand directoryLv1Brand);

    DirectoryLv1Brand getDirectoryLv1BrandById(Integer id);

    List<DirectoryLv1Brand> getAllDirectoryLv1Brands();

    void deleteDirectoryLv1Brand(Integer id);
}
