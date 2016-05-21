package com.bsu.bely.medical.service;

import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.entity.HospitalStanding;

import java.util.List;

public interface HospitalStandingService {
    void add (HospitalStanding hospitalStanding);
    List<HospitalStanding> getAll();
    List<HospitalStanding> getAllByPatientId(Long patientId);
    List<HospitalStanding> getAllForDoctor(Doctor doctor);
    void update(HospitalStanding hospitalStanding);
}
