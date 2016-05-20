package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.MedicalJournalDAO;
import com.bsu.bely.medical.entity.MedicalJournal;
import com.bsu.bely.medical.service.MedicalJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicalJournalServiceImpl implements MedicalJournalService {
    @Autowired
    private MedicalJournalDAO medicalJournalDAO;

    @Override
    @Transactional
    public void add(MedicalJournal medicalJournal) {
        medicalJournalDAO.add(medicalJournal);
    }

    @Override
    @Transactional
    public List<MedicalJournal> getAll() {
        return medicalJournalDAO.getAll();
    }

    @Override
    @Transactional
    public List<MedicalJournal> getAllByPatientId(Long patientId) {
        return medicalJournalDAO.getAllByPatientId(patientId);
    }

    @Override
    @Transactional
    public List<MedicalJournal> getAllByDoctorId(Long doctorId) {
        return medicalJournalDAO.getAllByDoctorId(doctorId);
    }
}