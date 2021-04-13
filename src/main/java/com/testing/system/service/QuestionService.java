package com.testing.system.service;

import com.testing.system.model.Question;

import java.util.List;

public interface QuestionService {
    void save(Question t);

    void delete(Question t);

    List<Question> findAll();

    Question findById(int id);

    String doQuestionIdString(Iterable<Question> questions, String appender);
}
