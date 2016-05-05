package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.DoctorDAO;
import com.bsu.bely.medical.entity.Doctor;
import com.bsu.bely.medical.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    @Transactional
    public List<Doctor> getAll() {
        return doctorDAO.getAll();
    }
}
