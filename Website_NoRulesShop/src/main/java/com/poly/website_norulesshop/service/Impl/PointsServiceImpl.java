package com.poly.website_norulesshop.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.website_norulesshop.Repository.PointsRepository;
import com.poly.website_norulesshop.entity.Points;
import com.poly.website_norulesshop.service.PointsService;

@Service
public class PointsServiceImpl implements PointsService {

    private final PointsRepository pointsRepository;

    @Autowired
    public PointsServiceImpl(PointsRepository pointsRepository) {
        this.pointsRepository = pointsRepository;
    }

    @Override
    public Points savePoints(Points points) {
        return pointsRepository.save(points);
    }

    @Override
    public Points getPointsById(Integer id) {
        return pointsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Points> getAllPoints() {
        return pointsRepository.findAll();
    }

    @Override
    public void deletePoints(Integer id) {
        pointsRepository.deleteById(id);
    }
}
