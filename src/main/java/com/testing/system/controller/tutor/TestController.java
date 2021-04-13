package com.testing.system.controller.tutor;

import com.testing.system.model.Test;
import com.testing.system.model.Topic;
import com.testing.system.service.TestService;
import com.testing.system.service.TopicService;
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
public class TestController {

    private final TopicService topicService;

    private final TestService testService;

    @Autowired
    public TestController(TopicService topicService, TestService testService) {
        this.topicService = topicService;
        this.testService = testService;
    }

    @PostMapping("/createTest")
    @ResponseBody
    public List<Test> createTest(Test test) {
        testService.save(test);

        Topic topic = topicService.findById(test.getTopic().getTopicId());

        Set<Test> tests = topic.getTests();

        return new ArrayList<>(tests).stream()
                .sorted(Comparator.comparing(Test::getTestId).reversed())
                .collect(Collectors.toList());
    }

    @PostMapping("/updateTest")
    public String updateTest(Test test) {
        testService.save(test);

        return "redirect:" + "topic#editTest";
    }

    @PostMapping(value = "/deleteTest")
    public String delete(Test test) {
        testService.delete(test);

        return "redirect:" + "topic#editTest";
    }

    @GetMapping(value = "/getTestById")
    public String getTestById(@RequestParam("testId") int testId, Model model) {
        Test test = testService.findById(testId);
        model.addAttribute(test);

        return "tutor/choseTest";
    }

    @GetMapping("/getTests")
    @ResponseBody
    public List<Test> getTestsByTopicId(@RequestParam(value = "topic", required = false) int topicId) {

        Topic topic = topicService.findById(topicId);

        Set<Test> tests = topic.getTests();

        return new ArrayList<>(tests);
    }
}
