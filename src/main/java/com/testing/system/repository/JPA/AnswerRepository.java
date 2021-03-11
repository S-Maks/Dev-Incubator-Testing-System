package com.testing.system.repository.JPA;

import com.testing.system.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    //void update(Answer answer);
}
