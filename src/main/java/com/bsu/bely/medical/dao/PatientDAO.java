package com.bsu.bely.medical.dao;


import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.Patient;

import java.util.List;

public interface PatientDAO {
    void addPatient(Patient patient);
    Patient getPatient(long id);
    List<Patient> getAll();
    List<Patient> getAllForDoctor(Doctor doctor);
}
