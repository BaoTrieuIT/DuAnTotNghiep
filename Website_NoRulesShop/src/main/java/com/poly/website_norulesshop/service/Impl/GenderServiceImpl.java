
package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.GenderRepository;
import com.poly.website_norulesshop.entity.Gender;
import com.poly.website_norulesshop.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;

    @Autowired
    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public Gender saveGender(Gender gender) {
        return genderRepository.save(gender);
    }

    @Override
    public Gender getGenderById(Integer id) {
        return genderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    @Override
    public void deleteGender(Integer id) {
        genderRepository.deleteById(id);
    }

}
