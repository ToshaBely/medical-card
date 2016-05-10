package com.bsu.bely.medical.dao;

import com.bsu.bely.medical.entity.HealthStatus;

import java.util.List;

public interface HealthStatusDAO {
    void add(HealthStatus healthStatus);
    List<HealthStatus> getAll();
    List<HealthStatus> getHealthStatusByPatientId(long patientId);
}
