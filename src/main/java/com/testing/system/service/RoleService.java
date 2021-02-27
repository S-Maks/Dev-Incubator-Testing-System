package com.testing.system.service;

import com.testing.system.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void update(Role t);

    void delete(Role t);

    void save(Role t);

    Role findById(int id);
}
