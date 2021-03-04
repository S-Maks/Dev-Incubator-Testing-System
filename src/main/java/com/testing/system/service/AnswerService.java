package com.testing.system.service;

import com.testing.system.model.Answer;
import com.testing.system.model.Literature;

import java.util.List;

public interface AnswerService {
    void save(Answer t);

    void update(Answer t);

    void delete(Answer t);

    List<Answer> findAll();

    Answer findById(int id);
}
