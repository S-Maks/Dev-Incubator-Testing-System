package com.testing.system.model;


import javax.persistence.*;

@Entity
@Table(name="answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int answerId;
    String description;
    boolean correct;
    //Question question;
}
