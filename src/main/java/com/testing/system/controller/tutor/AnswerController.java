package com.testing.system.controller.tutor;

import com.testing.system.model.Answer;
import com.testing.system.model.Question;
import com.testing.system.model.Topic;
import com.testing.system.service.AnswerService;
import com.testing.system.service.QuestionService;
import com.testing.system.service.TopicService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/tutor")
public class AnswerController {

    private final TopicService topicService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    @Autowired
    public AnswerController(TopicService topicService, QuestionService questionService, AnswerService answerService) {
        this.topicService = topicService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping("/answer")
    public String questionsAnswers(Model model) {
        List<Topic> allTopics = topicService.findAll();
        List<Answer> allAnswer = answerService.findAll();

        model.addAttribute("topics", allTopics);
        model.addAttribute("answers", allAnswer);

        return "tutor/answer";
    }

    @PostMapping("/updateAnswer")
    public String updateAnswer(@RequestParam("answerId") int answerId,
                               @RequestParam("description") String description,
                               @RequestParam("correct") boolean correct) {

        Answer answer = answerService.findById(answerId);
        answer.setDescription(description);
        answer.setCorrect(correct);

        answerService.save(answer);

        return "redirect:" + "answer#editAnswer";
    }

    @PostMapping("/createAnswer")
    @ResponseBody
    public List<Answer> createAnswer(Answer answer) {

        answerService.save(answer);

        Question question = answerService.findById(answer.getAnswerId()).getQuestion();

        Set<Answer> answers = question.getAnswerSet();

        return new ArrayList<>(answers).stream()
                .sorted(Comparator.comparing(Answer::getAnswerId).reversed())
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/deleteAnswer")
    public String delete(@ModelAttribute("answer") Answer answer) {
        answerService.delete(answer);

        return "redirect:" + "answer#editAnswer";
    }

    @GetMapping("/getAnswers")
    @ResponseBody
    public List<Answer> getAnswersByQuestionId(@RequestParam(value = "question", required = false) int questionId) {

        Question question = questionService.findById(questionId);

        Set<Answer> answers = question.getAnswerSet();

        return new ArrayList<>(answers);
    }
}
