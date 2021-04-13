package com.testing.system.controller.tutor;

import com.testing.system.model.*;
import com.testing.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/tutor")
public class TopicController {

    private final TopicService topicService;
    private final TestService testService;
    private final QuestionService questionService;
    private final LiteratureService literatureService;
    private final LinkService linkService;

    @Autowired
    public TopicController(TopicService topicService, TestService testService, QuestionService questionService,
                           LiteratureService literatureService, LinkService linkService) {
        this.topicService = topicService;
        this.testService = testService;
        this.questionService = questionService;
        this.literatureService = literatureService;
        this.linkService = linkService;
    }

    @GetMapping("/topic")
    public String topicTestQuestionLiteratureLink(Model model) {
        List<Topic> allTopics = topicService.findAll();
        List<Test> allTests = testService.findAll();
        List<Question> allQuestions = questionService.findAll();
        List<Literature> allLiterature = literatureService.findAll();
        List<Link> allLinks = linkService.findAll();

        model.addAttribute("topics", allTopics);
        model.addAttribute("tests", allTests);
        model.addAttribute("questions", allQuestions);
        model.addAttribute("literature", allLiterature);
        model.addAttribute("links", allLinks);

        return "tutor/topic";
    }

    @PostMapping("/createTopic")
    @ResponseBody
    public List<Topic> createTopic(Topic topic) {
        topicService.save(topic);

        return topicService.findAll().stream()
                .sorted(Comparator.comparing(Topic::getTopicId).reversed())
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/deleteTopic")
    public String delete(Topic topic) {
        topicService.delete(topic);

        return "redirect:" + "topic#editTopic";
    }

    @PostMapping(value = "/editTopic")
    public String edit(Topic topic) {
        topicService.save(topic);

        return "redirect:" + "topic#editTopic";
    }
}
