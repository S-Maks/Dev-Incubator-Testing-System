package com.testing.system.controller.user;

import com.testing.system.model.Test;
import com.testing.system.model.Topic;
import com.testing.system.service.TestService;
import com.testing.system.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/user")
public class ChoseTest {



    final
    TopicService topicService;

    public ChoseTest(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping(value = "/choseTest")
    @ResponseBody
    public List<Test> chooseTest(@RequestParam(value = "topic", required = false) int topicId) {

        Topic topic = topicService.findById(topicId);
        Set<Test> tests = topic.getTests();
        /*List<String> testNames = tests.stream().map(o -> o.getName()).collect(Collectors.toList());
        List<TestDTO> testDTOS = tests.stream().map(o -> new TestDTO(o)).collect(Collectors.toList());*/
        return tests.stream().collect(Collectors.toList());
    }


}
