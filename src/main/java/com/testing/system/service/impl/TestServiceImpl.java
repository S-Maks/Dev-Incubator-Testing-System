package com.testing.system.service.impl;

import com.testing.system.model.Test;
import com.testing.system.repository.TestRepository;
import com.testing.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;

    @Autowired
    public void setRepository(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional
    @Override
    public void save(Test t) {
        testRepository.save(t);
    }

    @Transactional
    @Override
    public void update(Test t) {
        testRepository.update(t);
    }

    @Transactional
    @Override
    public void delete(Test t) {
        testRepository.delete(t);
    }

    @Transactional
    @Override
    public List<Test> findAll() {
        return testRepository.findAll(Test.class);
    }

    @Transactional
    @Override
    public Test findById(int id) {
        return (Test) testRepository.findById(Test.class, id);
    }
}
