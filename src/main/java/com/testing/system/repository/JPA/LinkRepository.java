package com.testing.system.repository.JPA;

import com.testing.system.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link,Integer> {
    //void update(Link t);
}
