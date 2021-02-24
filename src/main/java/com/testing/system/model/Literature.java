package com.testing.system.model;


import javax.persistence.*;

@Entity
@Table(name="literature")
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int literatureId;
    String description;
    //Question question;
}
