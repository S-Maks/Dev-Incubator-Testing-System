package com.testing.system.repository.JPA;

import com.testing.system.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic,Integer> {

    Statistic save(Statistic statistic);

    Statistic findById (int id);


    @Query(value = "CALL getStat", nativeQuery = true)
    List<List<String>> getStat();

    @Query(value = "CALL getStatByUserId(:userId);", nativeQuery = true)
    List<List<String>> getStatByUserId(@Param("userId") Integer userId);

    @Query(value = "CALL getTestsStat", nativeQuery = true)
    List<List<String>> getTestsStat();

    @Query(value = "CALL getQuestionsStat", nativeQuery = true)
    List<List<String>> getQuestionsStat();

    @Query(value = "CALL getUsersStat", nativeQuery = true)
    List<List<String>> getUsersStat();
}
