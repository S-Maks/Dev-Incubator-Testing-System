package com.testing.system.controller.tutor;

import com.testing.system.model.*;
import com.testing.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/tutor")
public class QuestionController {

    private final TestService testService;
    private final QuestionService questionService;

    @Autowired
    public QuestionController(TestService testService, QuestionService questionService) {
        this.testService = testService;
        this.questionService = questionService;
    }

    @PostMapping("/createQuestion")
    @ResponseBody
    public List<Question> createQuestion(Question question) {

        questionService.save(question);

        Test test = testService.findById(question.getTest().getTestId());

        Set<Question> questions = test.getQuestions();

        return new ArrayList<>(questions).stream()
                .sorted(Comparator.comparing(Question::getQuestionId).reversed())
                .collect(Collectors.toList());
    }

    @PostMapping("/updateQuestion")
    public String updateQuestion(Question question) {
        questionService.save(question);

        return "redirect:" + "topic#editQuestion";
    }

    @PostMapping("/deleteQuestion")
    public String deleteQuestion(@RequestParam("questionId") int questionId) {

        questionService.delete(questionService.findById(questionId));

        return "redirect:" + "topic#editQuestion";
    }

    @GetMapping("/getQuestions")
    @ResponseBody
    public List<Question> getQuestionsByTestId(@RequestParam(value = "test", required = false) int testId) {

        Test test = testService.findById(testId);

        Set<Question> questions = test.getQuestions();

        return new ArrayList<>(questions);
    }
}
