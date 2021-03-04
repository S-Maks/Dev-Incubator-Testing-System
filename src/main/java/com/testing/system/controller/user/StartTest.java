package com.testing.system.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class StartTest {
    @GetMapping(value = "/startTest")
    public String startTest(@RequestParam(value = "test", required = false) int testId){

        return "user/question";
    }


}
