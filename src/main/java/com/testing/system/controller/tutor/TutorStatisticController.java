package com.testing.system.controller.tutor;

import com.testing.system.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tutor/statistic")
public class TutorStatisticController {

    private StatisticService statisticService;

    @Autowired
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping(value = "/home")
    public String statisticHome() {
        return "tutor/statistic/statistics";
    }

    @GetMapping(value = "/test")
    public String statisticTest(Model model) {

        model.addAttribute("statistic", statisticService.getTestsStat());

        return "tutor/statistic/statistic-test";
    }

    @GetMapping(value = "/question")
    public String statisticQuestion(Model model) {

        model.addAttribute("statistic", statisticService.getQuestionsStat());

        return "tutor/statistic/statistic-question";
    }

    @GetMapping(value = "/user")
    public String statisticUser(Model model) {

        model.addAttribute("statistic", statisticService.getUsersStat());

        return "tutor/statistic/statistic-user";
    }
}
