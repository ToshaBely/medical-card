package com.bsu.bely.medical.service;

import com.bsu.bely.medical.entity.HealthStatus;

import java.util.List;

public interface OverallHealthService {
    List<HealthStatus> getAll();
}
