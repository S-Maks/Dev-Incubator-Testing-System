package com.testing.system.service.JPAimpl;

import com.testing.system.model.Topic;
import com.testing.system.repository.JPA.TopicRepository;
import com.testing.system.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicRepository topicRepository;

    @Autowired
    public void setRepository(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Transactional
    @Override
    public void save(Topic t) {
        topicRepository.save(t);
    }

    @Transactional
    @Override
    public void delete(Topic t) {
        topicRepository.delete(t);
    }

    @Transactional
    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Transactional
    @Override
    public Topic findById(int id) {
        return (Topic) topicRepository.findById(id);
    }
}
