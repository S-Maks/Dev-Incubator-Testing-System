package com.testing.system.controller.user;


import com.testing.system.model.Question;
import com.testing.system.model.Test;
import com.testing.system.service.CookieService;
import com.testing.system.service.ModelService;
import com.testing.system.service.QuestionService;
import com.testing.system.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
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

    final ModelService modelService;

    public StartTest(QuestionService questionService, TestService testService, CookieService cookieService, ModelService modelService) {
        this.questionService = questionService;
        this.testService = testService;
        this.cookieService = cookieService;
        this.modelService = modelService;
    }

    @GetMapping(value = "/startTest")
    public String startTest(Model model, HttpServletResponse resp, @ModelAttribute("test") Integer testId) {
        Map<String, String> cookieMap = new LinkedHashMap<>();
        Test test = testService.findById(testId);
        Set<Question> questions = test.getQuestions();
        int firstQuestionId = questions.iterator().next().getQuestionId();
        String questionIdString = questionService.doQuestionIdString(questions, "=");
        Map<String, String> stringCookieMap = cookieService.doStringCookieMap(testId, "",questionIdString , firstQuestionId);
        cookieService.setResponseCookie(resp, stringCookieMap);
        Question byId = questionService.findById(firstQuestionId);
        modelService.setModelToStartTest(model,questions.size(),byId);
        return "user/question";
    }



}
