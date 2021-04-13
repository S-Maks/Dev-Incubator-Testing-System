package com.testing.system.controller.user;

import com.testing.system.model.User;
import com.testing.system.service.StatisticService;
import com.testing.system.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class StatisticsController {
    final
    StatisticService statisticService;

    final UserService userService;
    public StatisticsController(StatisticService statisticService, UserService userService) {
        this.statisticService = statisticService;
        this.userService = userService;
    }

    @GetMapping(value = "/getFullStat")
    String showFullStatistics(Model model){

        /*Object[] stat = statisticService.getStat();*/

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        User byLogin = userService.findByLogin(username);
        model.addAttribute("rows",statisticService.getStatByUserId(byLogin.getUserId()));

        return "user/statistics";
    }
}
