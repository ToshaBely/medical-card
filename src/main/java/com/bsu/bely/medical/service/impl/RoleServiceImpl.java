package com.bsu.bely.medical.service.impl;

import com.bsu.bely.medical.dao.RoleDAO;
import com.bsu.bely.medical.entity.Role;
import com.bsu.bely.medical.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public List<Role> getAll() {
        return roleDAO.getAll();
    }

    @Override
    @Transactional
    public Role getById(Long id) {
        return roleDAO.getById(id);
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDAO.add(role);
    }
}
