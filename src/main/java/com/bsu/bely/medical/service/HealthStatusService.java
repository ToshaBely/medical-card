package com.bsu.bely.medical.service;

import com.bsu.bely.medical.entity.HealthStatus;

import java.util.List;

public interface HealthStatusService {
    void add(HealthStatus healthStatus);
    List<HealthStatus> getAll();
    List<HealthStatus> getHealthStatusByPatientId(long patientId);
}
