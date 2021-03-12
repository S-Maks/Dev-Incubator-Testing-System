package com.testing.system.controller.user;

import com.testing.system.model.Question;
import com.testing.system.model.User;
import com.testing.system.service.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class EndTest {

    final
    QuestionService questionService;
    final
    AnswerService answerService;

    final
    CookieService cookieService;

    final
    StatisticService statisticService;

    final UserService userService;

    public EndTest(QuestionService questionService, AnswerService answerService, CookieService cookieService, StatisticService statisticService, UserService userService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.cookieService = cookieService;
        this.statisticService = statisticService;
        this.userService = userService;
    }

    @GetMapping(value = "/endTest")
    public String endTest(Model model, HttpServletRequest req, @ModelAttribute("answer") Integer answerId){
        Map<String, String> cookieMap = cookieService.getCookieMap(req);
        String[] questionIds = cookieMap.get("questionList").split("=");
        String currentQu = cookieMap.get("currentQuestion");
        StringBuilder answersBuilder = new StringBuilder(cookieMap.get("answers"));
        answersBuilder.append(currentQu).append("-").append(answerId).append("=");
        String[] split = answersBuilder.toString().split("=");
        Map<Question, Boolean> answerMap = new LinkedHashMap<>();
        for (String s : split) {
            String[] strings = s.split("-");
            answerMap.put(questionService.findById(Integer.valueOf(strings[0])),answerService.findById(Integer.valueOf(strings[1])).isCorrect());
        }
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        User byLogin = userService.findByLogin(username);
        for (Map.Entry<Question, Boolean> entry : answerMap.entrySet()) {
            statisticService.saveByParameters(new Date(),entry.getValue(),entry.getKey(),byLogin);
        }
        model.addAttribute("answersMap",answerMap);
        int i=0;
        return "user/testStat";
    }
}
