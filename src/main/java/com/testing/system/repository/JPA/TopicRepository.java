package com.testing.system.repository.JPA;

import com.testing.system.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Integer> {
    //void update (Topic user);

    Topic save(Topic topic);

    Topic findById (int id);
}
