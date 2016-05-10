package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.HealthStatusDAO;
import com.bsu.bely.medical.entity.HealthStatus;
import com.bsu.bely.medical.service.HealthStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HealthStatusServiceImpl implements HealthStatusService {
    @Autowired
    private HealthStatusDAO healthStatusDAO;

    @Override
    @Transactional
    public void add(HealthStatus healthStatus) {
        healthStatusDAO.add(healthStatus);
    }

    @Override
    @Transactional
    public List<HealthStatus> getAll() {
        return healthStatusDAO.getAll();
    }

    @Override
    @Transactional
    public List<HealthStatus> getHealthStatusByPatientId(long patientId) {
        return healthStatusDAO.getHealthStatusByPatientId(patientId);
    }
}
