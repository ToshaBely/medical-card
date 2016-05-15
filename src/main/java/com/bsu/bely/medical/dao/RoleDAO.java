package com.bsu.bely.medical.dao;

import com.bsu.bely.medical.entity.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getAll();
    Role getById(Long id);
    void add(Role role);
}
