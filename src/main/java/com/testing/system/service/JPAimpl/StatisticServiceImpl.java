package com.testing.system.service.JPAimpl;

import com.testing.system.model.Statistic;
import com.testing.system.repository.JPA.StatisticRepository;
import com.testing.system.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    private StatisticRepository statisticRepository;

    @Autowired
    public void setRepository(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public void save(Statistic t) {
        statisticRepository.save(t);
    }

  /*  @Override
    public void update(Statistic t) {
        statisticRepository.update(t);
    }*/

    @Override
    public void delete(Statistic t) {
        statisticRepository.delete(t);
    }

    @Override
    public List<Statistic> findAll() {
        return statisticRepository.findAll();
    }

    @Override
    public Statistic findById(int id) {
        return statisticRepository.findById(id);
    }
}
