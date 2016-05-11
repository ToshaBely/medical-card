package com.bsu.bely.medical.service;

import com.bsu.bely.medical.entity.MedicalJournal;

import java.util.List;

public interface MedicalJournalService {
    void add(MedicalJournal medicalJournal);
    List<MedicalJournal> getAll();
    List<MedicalJournal> getAllByPatientId(Long patientId);
}
