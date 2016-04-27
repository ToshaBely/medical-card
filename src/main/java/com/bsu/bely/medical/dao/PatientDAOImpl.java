package com.bsu.bely.medical.dao;

import com.bsu.bely.medical.entity.Patient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDAOImpl implements PatientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPatient(Patient patient) {
        sessionFactory.getCurrentSession().persist(patient);
    }

    @Override
    public Patient getPatient(long id) {
        return (Patient) sessionFactory.getCurrentSession().get(Patient.class, id);
    }
}
