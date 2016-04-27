package com.bsu.bely.medical.service;

import com.bsu.bely.medical.dao.PatientDAO;
import com.bsu.bely.medical.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDAO patientDAO;

    @Override
    @Transactional
    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }

    @Override
    @Transactional
    public Patient getPatient(long id) {
        return patientDAO.getPatient(id);
    }
}
