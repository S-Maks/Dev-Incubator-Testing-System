package com.testing.system.controller.user;

import com.testing.system.model.Answer;
import com.testing.system.model.Question;
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
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class NextQuestion {
    final
    QuestionService questionService;
    final
    CookieService cookieService;

    public NextQuestion(QuestionService questionService, CookieService cookieService) {
        this.questionService = questionService;
        this.cookieService = cookieService;
    }

    @GetMapping("/nextQuestion")
    public String nextQuestion(Model model, HttpServletRequest req, HttpServletResponse resp, @ModelAttribute("answer") Integer answerId) {
        int isLast = 0;
        Map<String, String> cookieMap = cookieService.getCookieMap(req);
        String[] questionIds = cookieMap.get("questionList").split("=");
        String currentQu = cookieMap.get("currentQuestion");
        StringBuilder answersBuilder = new StringBuilder(cookieMap.get("answers"));
        answersBuilder.append(currentQu).append("-").append(answerId).append("=");
        cookieMap.put("answers", answersBuilder.toString());
        for (int i = 0; i < questionIds.length; i++) {
            if (i == questionIds.length - 2) {
                isLast = 1;
            }
            if (questionIds[i].equals(currentQu)) {
                currentQu = questionIds[i + 1];
                cookieMap.put("currentQuestion", currentQu);
                break;
            }
        }
        Question byId = questionService.findById(Integer.valueOf(currentQu));
        model.addAttribute("isLast", isLast);
        model.addAttribute("question", byId);
        cookieService.setResponseCookie(resp, cookieMap);
        return "user/question";
    }


}
