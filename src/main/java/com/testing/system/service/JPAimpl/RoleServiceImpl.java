package com.testing.system.service.JPAimpl;

import com.testing.system.model.Role;
import com.testing.system.repository.JPA.RoleRepository;
import com.testing.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public void setRepository(RoleRepository repository) {
        this.roleRepository = repository;
    }

    @Transactional
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    /*@Transactional
    @Override
    public void update(Role t) {
        roleRepository.update(t);
    }*/

    @Transactional
    @Override
    public void delete(Role t) {
        roleRepository.delete(t);
    }

    @Transactional
    @Override
    public void save(Role t) {
        roleRepository.save(t);
    }

    @Transactional
    @Override
    public Role findById(int id) {
        return (Role) roleRepository.findById(id);
    }
}
