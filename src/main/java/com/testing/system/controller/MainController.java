package com.testing.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @GetMapping
    public String homePage(Model model) {
        String name="MAX";
        model.addAttribute("name",name);
        return "index";
    }
}
