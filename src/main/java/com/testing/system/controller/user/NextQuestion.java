package com.testing.system.controller.user;

import com.testing.system.model.Answer;
import com.testing.system.model.Question;
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
import java.util.List;

@Controller
@RequestMapping("/user")
public class NextQuestion {
    final
    QuestionService questionService;

    public NextQuestion(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/nextQuestion")
    public String nextQuestion(Model model, HttpServletRequest req, HttpServletResponse resp, @ModelAttribute("answer") Integer answerId){
        int isLast=0;
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
        answers.setValue(answersBuilder.toString());
        for (int i = 0; i < questionIds.length; i++) {
            if (i==questionIds.length-2){
                isLast=1;
            }
            if (questionIds[i].equals(currentQu)){
                currentQu=questionIds[i+1];
                currentQuestion.setValue(currentQu);
                break;
            }
        }
        model.addAttribute("isLast",isLast);

        Question byId = questionService.findById(Integer.valueOf(currentQu));
        List<Answer> answerList = byId.getAnswerList();
        model.addAttribute("question",byId);
        model.addAttribute("answerList",answerList);
        resp.addCookie(currentTestId);
        resp.addCookie(answers);
        resp.addCookie(questionIdList);
        resp.addCookie(currentQuestion);
        return "user/question";
    }


}
