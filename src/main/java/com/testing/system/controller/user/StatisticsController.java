package com.testing.system.controller.user;

import com.testing.system.model.Question;
import com.testing.system.model.Statistic;
import com.testing.system.model.User;
import com.testing.system.repository.JPA.StatisticRepository;
import com.testing.system.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/user")
public class StatisticsController {
    final
    StatisticService statisticService;

    public StatisticsController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping(value = "/getFullStat")
    String showFullStatistics(Model model){

        /*Object[] stat = statisticService.getStat();*/

        model.addAttribute("rows",statisticService.getStat());



        return "user/statistics";
    }
}
