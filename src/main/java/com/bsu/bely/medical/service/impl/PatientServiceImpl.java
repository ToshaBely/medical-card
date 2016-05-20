package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.PatientDAO;
import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.entity.type.RoleType;
import com.bsu.bely.medical.service.PatientService;
import com.bsu.bely.medical.utils.DoctorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional
    public List<Patient> getAll() {
        return patientDAO.getAll();
    }

    @Override
    @Transactional
    public List<Patient> getAllForDoctor(Doctor doctor) {
        if (DoctorUtils.hasDoctorRole(doctor, RoleType.ROLE_DEPARTMENT_HEAD)) {
            return patientDAO.getAll();
        }
        return patientDAO.getAllForDoctor(doctor);
    }
}
