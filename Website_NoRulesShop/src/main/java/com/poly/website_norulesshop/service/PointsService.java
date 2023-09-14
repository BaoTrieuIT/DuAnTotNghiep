package com.poly.website_norulesshop.service;

import com.poly.website_norulesshop.model.Points;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PointsService {
    Points savePoints(Points points);

    Points getPointsById(Long id);

    List<Points> getAllPoints();

    void deletePoints(Long id);
}
