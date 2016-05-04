package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.OverallHealthDAO;
import com.bsu.bely.medical.entity.OverallHealth;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OverallHealthDAOImpl implements OverallHealthDAO {
    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<OverallHealth> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(OverallHealth.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
