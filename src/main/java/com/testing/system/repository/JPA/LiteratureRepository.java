package com.testing.system.repository.JPA;

import com.testing.system.model.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureRepository extends JpaRepository<Literature,Integer> {

    //void update(Literature t);
}
