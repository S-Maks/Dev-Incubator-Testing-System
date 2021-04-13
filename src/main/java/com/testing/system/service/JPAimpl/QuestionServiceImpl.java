package com.testing.system.service.JPAimpl;

import com.testing.system.model.Question;
import com.testing.system.repository.JPA.QuestionRepository;
import com.testing.system.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public void setRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    @Override
    public void save(Question t) {
        questionRepository.save(t);
    }

    @Transactional
    @Override
    public void delete(Question t) {
        questionRepository.delete(t);
    }

    @Transactional
    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Transactional
    @Override
    public Question findById(int id) {
        return questionRepository.findById(id);
    }
}
