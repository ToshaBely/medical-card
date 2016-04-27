package com.bsu.bely.medical.dao;


import com.bsu.bely.medical.entity.Patient;

public interface PatientDAO {
    void addPatient(Patient patient);
    Patient getPatient(long id);
}
