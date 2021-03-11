package com.testing.system.repository.JPA;

import com.testing.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByLogin(String login);

    //void update (User user);

    User save(User user);

    User findById (int id);

}
