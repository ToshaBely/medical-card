package com.bsu.bely.medical.dao;


import com.bsu.bely.medical.entity.HospitalStanding;

import java.util.List;

public interface HospitalStandingDAO {
    void add (HospitalStanding hospitalStanding);
    List<HospitalStanding> getAll();
    List<HospitalStanding> getAllByPatientId(Long patientId);
}
