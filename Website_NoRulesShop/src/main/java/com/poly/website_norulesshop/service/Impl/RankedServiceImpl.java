package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.RankedRepository;
import com.poly.website_norulesshop.model.Ranked;
import com.poly.website_norulesshop.service.RankedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Ranked getRankedById(Long id) {
        return rankedRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ranked> getAllRankeds() {
        return rankedRepository.findAll();
    }

    @Override
    public void deleteRanked(Long id) {
        rankedRepository.deleteById(id);
    }
}
