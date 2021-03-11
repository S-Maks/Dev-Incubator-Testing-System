package com.testing.system.repository.JPA;

import com.testing.system.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {
    //void update (Test test);

    Test save(Test test);

    Test findById (int id);
}
