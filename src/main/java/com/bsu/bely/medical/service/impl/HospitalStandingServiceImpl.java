package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.HospitalStandingDAO;
import com.bsu.bely.medical.entity.HospitalStanding;
import com.bsu.bely.medical.service.HospitalStandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HospitalStandingServiceImpl implements HospitalStandingService {

    @Autowired
    private HospitalStandingDAO hospitalStandingDAO;

    @Override
    @Transactional
    public void add(HospitalStanding hospitalStanding) {
        hospitalStandingDAO.add(hospitalStanding);
    }

    @Override
    @Transactional
    public List<HospitalStanding> getAll() {
        return hospitalStandingDAO.getAll();
    }

    @Override
    @Transactional
    public List<HospitalStanding> getAllByPatientId(Long patientId) {
        return hospitalStandingDAO.getAllByPatientId(patientId);
    }

    @Override
    @Transactional
    public List<HospitalStanding> getAllByDoctorId(Long doctorId) {
        return hospitalStandingDAO.getAllByDoctorId(doctorId);
    }

    @Override
    @Transactional
    public void update(HospitalStanding hospitalStanding) {
        hospitalStandingDAO.update(hospitalStanding);
    }
}
