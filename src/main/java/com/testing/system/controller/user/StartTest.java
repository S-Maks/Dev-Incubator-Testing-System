package com.testing.system.controller.user;

import com.testing.system.model.Answer;
import com.testing.system.model.Question;
import com.testing.system.model.Test;
import com.testing.system.service.CookieService;
import com.testing.system.service.QuestionService;
import com.testing.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/user")
public class StartTest {
    final
    QuestionService questionService;
    final
    TestService testService;

    final
    CookieService cookieService;

    public StartTest(QuestionService questionService, TestService testService, CookieService cookieService) {
        this.questionService = questionService;
        this.testService = testService;
        this.cookieService = cookieService;
    }

    @GetMapping(value = "/startTest")
    public String startTest(Model model, HttpServletResponse resp, @ModelAttribute("test") Integer testId){
        Map<String,String> cookieMap=new LinkedHashMap<>();
        cookieMap.put("testId",testId.toString());
        cookieMap.put("answers","");
        Test test = testService.findById(testId);
        Set<Question> questions = test.getQuestions();
        StringBuilder questionIdListString=new StringBuilder();
        for (Question question : questions) {
            questionIdListString.append(question.getQuestionId()).append("=");
        }
        cookieMap.put("questionList",questionIdListString.toString());
        int firstQuestionId = questions.iterator().next().getQuestionId();
        cookieMap.put("currentQuestion", String.valueOf(firstQuestionId));
        cookieService.setResponseCookie(resp,cookieMap);
        Question byId = questionService.findById(firstQuestionId);
        Set<Answer> answerList = byId.getAnswerSet();
        model.addAttribute("isLast",questions.size()==1?1:0);
        model.addAttribute("question",byId);
        model.addAttribute("answerList",answerList);
        return "user/question";
    }


}
