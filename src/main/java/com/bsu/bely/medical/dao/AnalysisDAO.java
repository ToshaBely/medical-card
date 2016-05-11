package com.bsu.bely.medical.dao;

import com.bsu.bely.medical.entity.Analysis;

import java.util.List;

public interface AnalysisDAO {
    void add (Analysis analysis);
    List<Analysis> getAll();
    List<Analysis> getAllByPatientId(Long patientId);
}
