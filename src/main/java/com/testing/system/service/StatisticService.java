package com.testing.system.service;

import com.testing.system.model.Question;
import com.testing.system.model.Statistic;
import com.testing.system.model.User;

import java.util.Date;
import java.util.List;

public interface StatisticService {
    void save(Statistic t);

    //void update(Statistic t);

    void delete(Statistic t);

    List<Statistic> findAll();

    Statistic findById(int id);

    void saveByParameters(Date date, Boolean correct, Question question, User user);

    public List<List<String>> getFullListToShowOnView();

    List<List<String>> getStat();
}
