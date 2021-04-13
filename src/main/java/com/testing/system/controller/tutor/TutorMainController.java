package com.testing.system.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tutor")
public class TutorMainController {

    @GetMapping
    public String tutorHome() {
        return "tutor/home";
    }
}
