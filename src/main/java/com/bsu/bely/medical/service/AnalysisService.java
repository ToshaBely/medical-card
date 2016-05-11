package com.bsu.bely.medical.service;

import com.bsu.bely.medical.entity.Analysis;

import java.util.List;

public interface AnalysisService {
    void add (Analysis analysis);
    List<Analysis> getAll();
    List<Analysis> getAllByPatientId(Long patientId);
}
