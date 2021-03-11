package com.testing.system.service;

import com.testing.system.model.Test;

import java.util.List;

public interface TestService {
    void save(Test t);

    //void update(Test t);

    void delete(Test t);

    List<Test> findAll();

    Test findById(int id);
}
