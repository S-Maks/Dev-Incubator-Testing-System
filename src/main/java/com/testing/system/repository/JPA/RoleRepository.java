package com.testing.system.repository.JPA;

import com.testing.system.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    //void update (Role role);

    Role save(Role role);

    Role findById (int id);

}
