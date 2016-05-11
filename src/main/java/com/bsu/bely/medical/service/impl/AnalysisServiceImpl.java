package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.AnalysisDAO;
import com.bsu.bely.medical.entity.Analysis;
import com.bsu.bely.medical.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AnalysisDAO analysisDAO;

    @Override
    @Transactional
    public void add(Analysis analysis) {
        analysisDAO.add(analysis);
    }

    @Override
    @Transactional
    public List<Analysis> getAll() {
        return analysisDAO.getAll();
    }

    @Override
    @Transactional
    public List<Analysis> getAllByPatientId(Long patientId) {
        return analysisDAO.getAllByPatientId(patientId);
    }
}
