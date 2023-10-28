package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Gender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GenderService {
    Gender saveGender(Gender gender);

    Gender getGenderById(Integer id);

    List<Gender> getAllGenders();

    void deleteGender(Integer id);
}
