package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.MedicalJournalDAO;
import com.bsu.bely.medical.entity.MedicalJournal;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalJournalDAOImpl implements MedicalJournalDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(MedicalJournal medicalJournal) {
        sessionFactory.getCurrentSession().persist(medicalJournal);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalJournal> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(MedicalJournal.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalJournal> getAllByPatientId(Long patientId) {
        return sessionFactory.getCurrentSession().createCriteria(MedicalJournal.class)
                .add(Restrictions.eq("patient.id", patientId))
                .addOrder(Order.desc("date"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MedicalJournal> getAllByDoctorId(Long doctorId) {
        return sessionFactory.getCurrentSession().createCriteria(MedicalJournal.class)
                .add(Restrictions.eq("doctor.id", doctorId))
                .addOrder(Order.desc("date"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
