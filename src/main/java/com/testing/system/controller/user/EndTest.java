package com.testing.system.controller.user;

import com.testing.system.model.Answer;
import com.testing.system.model.Question;
import com.testing.system.service.AnswerService;
import com.testing.system.service.CookieService;
import com.testing.system.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/user")
public class EndTest {

    final
    QuestionService questionService;
    final
    AnswerService answerService;

    final
    CookieService cookieService;

    public EndTest(QuestionService questionService, AnswerService answerService, CookieService cookieService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.cookieService = cookieService;
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
        model.addAttribute("answersMap",answerMap);
        int i=0;
        return "user/testStat";
    }
}
