package com.testing.system.repository.JPA;

import com.testing.system.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    //void update (Question question);

    Question save(Question question);

    Question findById (int id);
}
