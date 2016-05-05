package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.HealthStatusDAO;
import com.bsu.bely.medical.entity.HealthStatus;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HealthStatusDAOImpl implements HealthStatusDAO {
    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<HealthStatus> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(HealthStatus.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
