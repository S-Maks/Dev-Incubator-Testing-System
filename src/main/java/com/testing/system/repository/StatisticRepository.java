package com.testing.system.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticRepository implements DaoRepository<StatisticRepository>{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getBeanToBeAutowired() {
        return sessionFactory;
    }
}
