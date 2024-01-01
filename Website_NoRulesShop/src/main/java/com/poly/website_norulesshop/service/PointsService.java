package com.poly.website_norulesshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.entity.Points;
@Service
public interface PointsService {
    Points savePoints(Points points);

    Points getPointsById(Integer id);

    List<Points> getAllPoints();

    void deletePoints(Integer id);
}
