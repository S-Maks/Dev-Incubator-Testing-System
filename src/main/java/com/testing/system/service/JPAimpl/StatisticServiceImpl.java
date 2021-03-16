package com.testing.system.service.JPAimpl;

import com.testing.system.model.Question;
import com.testing.system.model.Statistic;
import com.testing.system.model.User;
import com.testing.system.repository.JPA.StatisticRepository;
import com.testing.system.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public void saveByParameters(Date date, Boolean correct, Question question, User user) {
        Statistic statistic = new Statistic();
        statistic.setUser(user);
        statistic.setQuestion(question);
        statistic.setDate(date);
        statistic.setCorrect(correct);
        save(statistic);
    }

    @Override
    public List<List<String>> getFullListToShowOnView() {
        List<Statistic> statisticListAll = findAll();
        Map<User, List<Statistic>> userAndStatisticsList = statisticListAll.stream().collect(Collectors.groupingBy(Statistic::getUser));
        Map<User,Map<Question,List<Statistic>>> mapUserQuestionListStatistics=new LinkedHashMap<>();
        for (Map.Entry<User, List<Statistic>> entry : userAndStatisticsList.entrySet()) {
            Map<Question, List<Statistic>> collect1 = entry.getValue().stream().collect(Collectors.groupingBy(Statistic::getQuestion));
            mapUserQuestionListStatistics.put(entry.getKey(),collect1);
        }
        Map<User,Map<Question,String[]>> mapUserQuestionCountStat =new LinkedHashMap<>();
        List<List<String>> listToShow = new LinkedList<>();
        for (Map.Entry<User, Map<Question, List<Statistic>>> userMapEntry : mapUserQuestionListStatistics.entrySet()) {
            Map<Question,String[]> questionStringMap=new LinkedHashMap<>();

            for (Map.Entry<Question, List<Statistic>> questionListEntry : userMapEntry.getValue().entrySet()) {
                List<String> row =new LinkedList<>();
                int statisticCount=0;
                int rightStatistic=0;
                for (Statistic statistic : questionListEntry.getValue()) {
                    statisticCount++;
                    if (statistic.isCorrect()) rightStatistic++;
                }
                String[] strings = new String[2];
                strings[0]= String.valueOf(statisticCount);
                float percent=(float) rightStatistic/statisticCount;
                strings[1]=String.valueOf(percent);
                questionStringMap.put(questionListEntry.getKey(),strings);

                row.add(userMapEntry.getKey().getLogin());
                row.add(questionListEntry.getKey().getTest().getName());
                row.add(questionListEntry.getKey().getDescription());
                row.add(String.valueOf(statisticCount));
                row.add(String.format("%.2f",percent*100));
                listToShow.add(row);
            }

            mapUserQuestionCountStat.put(userMapEntry.getKey(),questionStringMap);
        }
        return listToShow;
    }

    public List<List<String>> getStat(){
        return statisticRepository.getStat();
    }

    @Override
    public List<List<String>> getStatByUserId(int userId) {
        return statisticRepository.getStatByUserId(userId);
    }
}
