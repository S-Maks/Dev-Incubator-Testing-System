package com.testing.system.controller.user;

import com.testing.system.model.Answer;
import com.testing.system.model.Question;
import com.testing.system.service.AnswerService;
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

    public EndTest(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping(value = "/endTest")
    public String endTest(Model model, HttpServletRequest req, HttpServletResponse resp, @ModelAttribute("answer") Integer answerId){
        Cookie[] cookies = req.getCookies();
        Cookie currentTestId = null;
        Cookie answers = null;
        Cookie questionIdList = null;
        Cookie currentQuestion = null;
        for (Cookie cookie : cookies) {
            switch (cookie.getName()){
                case "questionList"-> questionIdList=cookie;
                case "testId"->currentTestId=cookie;
                case "answers"->answers=cookie;
                case "currentQuestion"->currentQuestion=cookie;
            }
        }

        String[] questionIds = questionIdList.getValue().split("=");
        String currentQu = currentQuestion.getValue();
        StringBuilder answersBuilder = new StringBuilder(answers.getValue());
        answersBuilder.append(currentQu).append("-").append(answerId).append("=");
        answers.setValue("");
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
