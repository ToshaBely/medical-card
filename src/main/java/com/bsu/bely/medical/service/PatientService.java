package com.bsu.bely.medical.service;

import com.bsu.bely.medical.entity.Patient;

public interface PatientService {
    void addPatient(Patient patient);
    Patient getPatient(long id);
}
