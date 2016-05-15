package com.bsu.bely.medical.dao.impl;

import com.bsu.bely.medical.dao.RoleDAO;
import com.bsu.bely.medical.entity.Role;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Role.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    @Override
    public Role getById(Long id) {
        return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().persist(role);
    }
}
