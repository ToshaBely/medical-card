package com.bsu.bely.medical.service;

import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.Patient;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);
    Patient getPatient(long id);
    List<Patient> getAll();
    List<Patient> getAllForDoctor(Doctor doctor);
}
