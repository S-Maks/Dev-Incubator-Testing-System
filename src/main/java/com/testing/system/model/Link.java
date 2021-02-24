package com.testing.system.model;


import javax.persistence.*;

@Entity
@Table(name="link")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int linkId;
    String link;

    @OneToOne
    Literature literature;
}
