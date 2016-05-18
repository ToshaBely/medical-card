package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.HospitalStandingDAO;
import com.bsu.bely.medical.entity.HospitalStanding;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalStandingDAOImpl implements HospitalStandingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(HospitalStanding hospitalStanding) {
        sessionFactory.getCurrentSession().persist(hospitalStanding);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HospitalStanding> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(HospitalStanding.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HospitalStanding> getAllByPatientId(Long patientId) {
        return sessionFactory.getCurrentSession().createCriteria(HospitalStanding.class)
                .add(Restrictions.eq("patient.id", patientId))
                .addOrder(Order.asc("enteringDate"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HospitalStanding> getAllByDoctorId(Long doctorId) {
        return sessionFactory.getCurrentSession().createCriteria(HospitalStanding.class)
                .add(Restrictions.or(
                        Restrictions.eq("departmentHead.id", doctorId),
                        Restrictions.eq("therapist.id", doctorId)))
                .addOrder(Order.asc("enteringDate"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
