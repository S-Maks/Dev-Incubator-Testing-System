package com.testing.system.service.impl;

import com.testing.system.model.Answer;
import com.testing.system.repository.AnswerRepository;
import com.testing.system.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    AnswerRepository answerRepository;

    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }



    @Transactional
    @Override
    public void update(Answer answer) {
        answerRepository.update(answer);

    }

    @Transactional
    @Override
    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    @Transactional
    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }

    @Transactional
    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll(Answer.class);
    }

    @Transactional
    @Override
    public Answer findById(int id) {
        return (Answer) answerRepository.findById(Answer.class,id);
    }
}
