package com.testing.system.repository.JPA;

import com.testing.system.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic,Integer> {
    //void update (Statistic statistic);

    Statistic save(Statistic statistic);

    Statistic findById (int id);

}
