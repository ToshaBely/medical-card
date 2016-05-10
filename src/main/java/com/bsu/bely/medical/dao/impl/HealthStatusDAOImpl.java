package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.HealthStatusDAO;
import com.bsu.bely.medical.entity.HealthStatus;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HealthStatusDAOImpl implements HealthStatusDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(HealthStatus healthStatus) {
        sessionFactory.getCurrentSession().persist(healthStatus);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HealthStatus> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(HealthStatus.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HealthStatus> getHealthStatusByPatientId(long patientId) {
        return sessionFactory.getCurrentSession().createCriteria(HealthStatus.class)
                .add(Restrictions.eq("patient.id", patientId))
                .addOrder(Order.desc("date"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
