package com.poly.website_norulesshop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.RankedRepository;
import com.poly.website_norulesshop.entity.Ranked;
import com.poly.website_norulesshop.service.RankedService;

@Service
public class RankedServiceImpl implements RankedService {

    private final RankedRepository rankedRepository;

    @Autowired
    public RankedServiceImpl(RankedRepository rankedRepository) {
        this.rankedRepository = rankedRepository;
    }

    @Override
    public Ranked saveRanked(Ranked ranked) {
        return rankedRepository.save(ranked);
    }

    @Override
    public Ranked getRankedById(Integer id) {
        return rankedRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ranked> getAllRankeds() {
        return rankedRepository.findAll();
    }

    @Override
    public void deleteRanked(Integer id) {
        rankedRepository.deleteById(id);
    }
}
