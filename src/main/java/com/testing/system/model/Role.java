package com.testing.system.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    private String role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<User> userList;
}
