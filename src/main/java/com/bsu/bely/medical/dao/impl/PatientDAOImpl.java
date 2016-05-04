package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.PatientDAO;
import com.bsu.bely.medical.entity.Patient;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<Patient> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Patient.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
