package com.testing.system.service;

import com.testing.system.model.User;

import java.util.List;

public interface UserService {
    void save(User t);

    void update(User t);

    void delete(User t);

    List<User> findAll();

    User findById(int id);
}
