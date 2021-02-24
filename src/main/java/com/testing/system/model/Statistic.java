package com.testing.system.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statisticId;

    private Date date;

    private boolean correct;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
}
