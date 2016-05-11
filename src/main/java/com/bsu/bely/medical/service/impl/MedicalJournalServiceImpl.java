package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.MedicalJournalDAO;
import com.bsu.bely.medical.entity.MedicalJournal;
import com.bsu.bely.medical.service.MedicalJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalJournalServiceImpl implements MedicalJournalService {
    @Autowired
    private MedicalJournalDAO medicalJournalDAO;

    @Override
    public void add(MedicalJournal medicalJournal) {
        medicalJournalDAO.add(medicalJournal);
    }

    @Override
    public List<MedicalJournal> getAll() {
        return medicalJournalDAO.getAll();
    }

    @Override
    public List<MedicalJournal> getAllByPatientId(Long patientId) {
        return medicalJournalDAO.getAllByPatientId(patientId);
    }
}