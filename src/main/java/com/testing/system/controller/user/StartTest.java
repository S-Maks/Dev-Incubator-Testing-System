package com.testing.system.controller.user;

import com.testing.system.model.Answer;
import com.testing.system.model.Question;
import com.testing.system.model.Test;
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
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/user")
public class StartTest {
    final
    QuestionService questionService;
    final
    TestService testService;

    public StartTest(QuestionService questionService, TestService testService) {
        this.questionService = questionService;
        this.testService = testService;
    }

    @GetMapping(value = "/startTest")
    public String startTest(Model model, HttpServletRequest req, HttpServletResponse resp, @ModelAttribute("test") Integer testId){
        Cookie currentTestId = new Cookie("testId",req.getRequestURL().toString());
        currentTestId.setValue(testId.toString());
        Cookie answers = new Cookie("answers","");
        Cookie questionIdList = new Cookie("questionList", "");
        Cookie currentQuestion = new Cookie("currentQuestion", "");
        Test test = testService.findById(testId);
        Set<Question> questions = test.getQuestions();
        StringBuilder questionIdListString=new StringBuilder();
        for (Question question : questions) {
            questionIdListString.append(question.getQuestionId()).append("=");
        }
        questionIdList.setValue(questionIdListString.toString());

        int firstQuestionId = questions.iterator().next().getQuestionId();
        currentQuestion.setValue(String.valueOf(firstQuestionId));
        resp.addCookie(currentTestId);
        resp.addCookie(answers);
        resp.addCookie(questionIdList);
        resp.addCookie(currentQuestion);

        Question byId = questionService.findById(firstQuestionId);
        List<Answer> answerList = byId.getAnswerList();
        model.addAttribute("isLast",questions.size()==1?1:0);
        model.addAttribute("question",byId);
        model.addAttribute("answerList",answerList);
        return "user/question";
    }


}
