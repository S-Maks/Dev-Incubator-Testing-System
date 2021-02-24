package com.testing.system.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoRepository<T> {
    SessionFactory getBeanToBeAutowired();

    default List<T> findAll(Class T) {
        return getBeanToBeAutowired().getCurrentSession().createQuery("from " + T.getSimpleName()).list();
    }
}
