package com.testing.system.controller.user;

import com.testing.system.model.Literature;
import com.testing.system.model.Test;
import com.testing.system.model.Topic;
import com.testing.system.repository.DaoRepository;
import com.testing.system.service.LiteratureService;
import com.testing.system.service.TestService;
import com.testing.system.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/user")
public class UserHome {
    final
    LiteratureService literatureService;
    final
    TopicService topicService;
    final
    TestService testService;


    @Autowired
    public UserHome(LiteratureService literatureService, TopicService topicService, TestService testService) {
        this.literatureService = literatureService;
        this.topicService = topicService;
        this.testService = testService;
    }

    @GetMapping
    public String userHome(Model model){


        return "user/home";
    }

    @GetMapping(value = "/choseTopic")
    public String choseTest(Model model){
        List<Topic> allTopics = topicService.findAll();
        Set<Test> tests = allTopics.get(0).getTests();

        model.addAttribute("topics",allTopics);
        model.addAttribute("tests",tests);
        return "user/choseTest";
    }

    @GetMapping(value = "/testLiterature")
    public String testLiterature(){
        Literature byId = literatureService.findById(6);

        Test byId1 = testService.findById(5);
        List<Literature> all = literatureService.findAll();
        int i=0;

        return "";
    }

}
