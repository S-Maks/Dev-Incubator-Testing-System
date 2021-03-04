package com.testing.system.controller.user;

import com.testing.system.model.Literature;
import com.testing.system.repository.DaoRepository;
import com.testing.system.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value = "/user")
public class UserHome {
    final
    LiteratureService literatureService;


    @Autowired
    public UserHome(LiteratureService literatureService) {
        this.literatureService = literatureService;
    }

    @GetMapping
    public String userHome(){

        Literature byId = literatureService.findById(2);
        System.out.println(byId.getQuestion().getDescription());
        return "user/home";
    }
}
