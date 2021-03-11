package com.testing.system.service;

import com.testing.system.model.Question;

import java.util.List;

public interface QuestionService {
    void save(Question t);

    //void update(Question t);

    void delete(Question t);

    List<Question> findAll();

    Question findById(int id);
}
