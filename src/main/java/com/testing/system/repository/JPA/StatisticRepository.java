package com.testing.system.repository.JPA;

import com.testing.system.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic,Integer> {
    //void update (Statistic statistic);

    Statistic save(Statistic statistic);

    Statistic findById (int id);


    @Query(value = "CALL getStat", nativeQuery = true)
    List<List<String>> getStat();


}
