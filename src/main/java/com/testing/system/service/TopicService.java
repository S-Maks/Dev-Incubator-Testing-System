package com.testing.system.service;

import com.testing.system.model.Topic;

import java.util.List;

public interface TopicService {
    void save(Topic t);

    void delete(Topic t);

    List<Topic> findAll();

    Topic findById(int id);
}
