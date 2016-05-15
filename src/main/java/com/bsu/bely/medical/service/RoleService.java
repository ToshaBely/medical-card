package com.bsu.bely.medical.service;

import com.bsu.bely.medical.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getById(Long id);
    void add(Role role);
}
