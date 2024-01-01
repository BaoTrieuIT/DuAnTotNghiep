package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.entity.Ranked;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RankedService {
    Ranked saveRanked(Ranked ranked);

    Ranked getRankedById(Integer id);

    List<Ranked> getAllRankeds();

    void deleteRanked(Integer
     id);
}
