package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.DoctorDAO;
import com.bsu.bely.medical.entity.Doctor;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDAOImpl implements DoctorDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Doctor> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Doctor.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public Doctor getDoctor(Long doctorId) {
        return (Doctor) sessionFactory.getCurrentSession().get(Doctor.class, doctorId);
    }
}
