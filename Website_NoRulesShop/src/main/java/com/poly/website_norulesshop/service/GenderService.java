package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.Gender;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GenderService {
    Gender saveGender(Gender gender);

    Gender getGenderById(Integer id);

    List<Gender> getAllGenders();

    void deleteGender(Integer id);
}
