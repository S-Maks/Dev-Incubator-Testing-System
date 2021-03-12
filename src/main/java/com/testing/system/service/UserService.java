package com.testing.system.service;

import com.testing.system.model.User;

import java.util.List;

public interface UserService {
    void save(User t, int roleId);

    //void update(User t);

    User findByLogin(String login);

    void delete(User t);

    List<User> findAll();

    User findById(int id);
}
