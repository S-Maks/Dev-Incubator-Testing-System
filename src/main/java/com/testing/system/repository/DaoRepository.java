package com.testing.system.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoRepository<T> {
    SessionFactory getBeanToBeAutowired();

    default List<T> findAll(Class T) {
        return getBeanToBeAutowired().getCurrentSession().createQuery("from " + T.getSimpleName()).list();
    }

    default void save(T t) {
        getBeanToBeAutowired().getCurrentSession().save(t);
    }

    default void update(T t) {
        getBeanToBeAutowired().getCurrentSession().update(t);
    }

    default void delete(T t) {
        getBeanToBeAutowired().getCurrentSession().delete(t);
    }

    default T findById(Class T, int id) {
        return (T)getBeanToBeAutowired().getCurrentSession().get(T,id);
    }
}
