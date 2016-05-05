package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.HealthStatusDAO;
import com.bsu.bely.medical.entity.HealthStatus;
import com.bsu.bely.medical.service.OverallHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OverallHealthServiceImpl implements OverallHealthService {
    @Autowired
    private HealthStatusDAO healthStatusDAO;

    @Override
    @Transactional
    public List<HealthStatus> getAll() {
        return healthStatusDAO.getAll();
    }
}
