package com.testing.system.service;

import com.testing.system.model.Statistic;

import java.util.List;

public interface StatisticService {
    void save(Statistic t);

    void update(Statistic t);

    void delete(Statistic t);

    List<Statistic> findAll();

    Statistic findById(int id);
}
