package com.testing.system.service.impl;

import com.testing.system.model.Role;
import com.testing.system.model.User;
import com.testing.system.repository.RoleRepository;
import com.testing.system.repository.UserRepository;
import com.testing.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void save(User t) {
        userRepository.save(t);
    }

    @Transactional
    @Override
    public void update(User t) {
        userRepository.update(t);
    }

    @Transactional
    @Override
    public void delete(User t) {
        userRepository.delete(t);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return userRepository.findAll(User.class);
    }

    @Transactional
    @Override
    public User findById(int id) {
        return (User) userRepository.findById(User.class, id);
    }
}
