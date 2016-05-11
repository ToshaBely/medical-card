package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.AnalysisDAO;
import com.bsu.bely.medical.entity.Analysis;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnalysisDAOImpl implements AnalysisDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Analysis analysis) {
        sessionFactory.getCurrentSession().persist(analysis);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Analysis> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Analysis.class).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Analysis> getAllByPatientId(Long patientId) {
        return sessionFactory.getCurrentSession().createCriteria(Analysis.class)
                .add(Restrictions.eq("patient.id", patientId))
                .addOrder(Order.desc("date"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
