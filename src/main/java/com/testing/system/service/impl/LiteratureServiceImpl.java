package com.testing.system.service.impl;

import com.testing.system.model.Literature;
import com.testing.system.repository.LiteratureRepository;
import com.testing.system.repository.QuestionRepository;
import com.testing.system.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LiteratureServiceImpl implements LiteratureService {

    private LiteratureRepository literatureRepository;

    @Autowired
    public void setRepository(LiteratureRepository literatureRepository) {
        this.literatureRepository=literatureRepository;
    }

    @Transactional
    @Override
    public void save(Literature t) {
        literatureRepository.save(t);

    }

    @Transactional
    @Override
    public void update(Literature t) {
        literatureRepository.update(t);

    }

    @Transactional
    @Override
    public void delete(Literature t) {
        literatureRepository.delete(t);

    }

    @Transactional
    @Override
    public List<Literature> findAll() {
        return literatureRepository.findAll(Literature.class);
    }

    @Transactional
    @Override
    public Literature findById(int id) {
        return (Literature) literatureRepository.findById(Literature.class,id);
    }
}
