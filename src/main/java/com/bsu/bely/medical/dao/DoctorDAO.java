package com.bsu.bely.medical.dao;

import com.bsu.bely.medical.entity.Doctor;

import java.util.List;

public interface DoctorDAO {
    List<Doctor> getAll();
    Doctor getDoctor(Long doctorId);
    Doctor getDoctorByLogin(String userName);
}
