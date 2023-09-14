package com.poly.website_norulesshop.service.Impl;

import com.poly.website_norulesshop.Repository.PointsRepository;
import com.poly.website_norulesshop.model.Points;
import com.poly.website_norulesshop.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Points getPointsById(Long id) {
        return pointsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Points> getAllPoints() {
        return pointsRepository.findAll();
    }

    @Override
    public void deletePoints(Long id) {
        pointsRepository.deleteById(id);
    }
}
