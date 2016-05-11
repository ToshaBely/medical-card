package com.bsu.bely.medical.dao;

import com.bsu.bely.medical.entity.MedicalJournal;

import java.util.List;

public interface MedicalJournalDAO {
    void add(MedicalJournal medicalJournal);
    List<MedicalJournal> getAll();
    List<MedicalJournal> getAllByPatientId(Long patientId);
}
