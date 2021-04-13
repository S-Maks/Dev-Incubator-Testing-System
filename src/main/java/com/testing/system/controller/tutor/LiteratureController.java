package com.testing.system.controller.tutor;

import com.testing.system.model.Link;
import com.testing.system.model.Literature;
import com.testing.system.model.Question;
import com.testing.system.service.LiteratureService;
import com.testing.system.service.QuestionService;
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
public class LiteratureController {

    private final QuestionService questionService;
    private final LiteratureService literatureService;

    @Autowired
    public LiteratureController(QuestionService questionService, LiteratureService literatureService) {
        this.questionService = questionService;
        this.literatureService = literatureService;
    }


    @PostMapping("/createLiterature")
    @ResponseBody
    public List<Literature> createLiteratureWithLink(@RequestParam("questionId") int questionId,
                                           @RequestParam("description") String description,
                                           @RequestParam("link") String url) {

        Question question = new Question();
        question.setQuestionId(questionId);

        Literature literature = new Literature();
        literature.setDescription(description);
        literature.setQuestion(question);

        Link link1 = new Link();
        link1.setLink(url);
        link1.setLiterature(literature);
        literature.setLink(link1);

        literatureService.save(literature);

        Set<Literature> literatures = questionService.findById(literature.getQuestion().getQuestionId()).getLiteratureSet();

        return new ArrayList<>(literatures).stream()
                .sorted(Comparator.comparing(Literature::getLiteratureId).reversed())
                .collect(Collectors.toList());
    }

    @PostMapping("/updateLiterature")
    public String updateLiteratureWithLink(@RequestParam("literatureId") int literatureId,
                                           @RequestParam("questionId") int questionId,
                                           @RequestParam("description") String description,
                                           @RequestParam("link") String url) {

        Literature literature = literatureService.findById(literatureId);
        literature.setQuestion(questionService.findById(questionId));
        literature.setDescription(description);
        literature.getLink().setLink(url);

        literatureService.save(literature);

        return "redirect:" + "topic#editLiterature";
    }

    @PostMapping(value = "/deleteLiterature")
    public String delete(Literature literature) {
        literatureService.delete(literature);

        return "redirect:" + "topic#editLiterature";
    }

    @GetMapping("/getLiterature")
    @ResponseBody
    public List<Literature> getLiteratureByQuestionId(@RequestParam(value = "question", required = false) int questionId) {

        Question question = questionService.findById(questionId);

        Set<Literature> literatures = question.getLiteratureSet();

        return new ArrayList<>(literatures);
    }

    @GetMapping("/getLink")
    @ResponseBody
    public List<Link> getLinkByLiteratureId(@RequestParam(value = "literature", required = false) int literatureId) {

        Literature literature = literatureService.findById(literatureId);

        return List.of(literature.getLink());
    }
}
