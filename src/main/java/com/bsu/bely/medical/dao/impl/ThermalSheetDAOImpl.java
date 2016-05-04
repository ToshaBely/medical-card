package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.ThermalSheetDAO;
import com.bsu.bely.medical.entity.ThermalSheet;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThermalSheetDAOImpl implements ThermalSheetDAO {
    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<ThermalSheet> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(ThermalSheet.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public void add(ThermalSheet thermalSheet) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ThermalSheet> getThermalSheetsByPatientId(long patientId) {
        return sessionFactory.getCurrentSession().createCriteria(ThermalSheet.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
