package com.testing.system.controller;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @GetMapping(value = "/login")
    public String loginPage(Authentication authentication) {
        if(authentication!=null){
            return "redirect:/" +  redirectToHomePageRole();
        }
        return "login";
    }

    @GetMapping(value = "/")
    public String homePage() {
        return "index";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    private String redirectToHomePageRole(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        switch (((UserDetails) principal).getAuthorities().toString()) {
            case "[ROLE_ADMIN]" -> {
                return "admin";
            }
            case "[ROLE_TUTOR]" -> {
                return "tutor";
            }
            case "[ROLE_USER]" -> {
                return "user";
            }
            default -> {
                return "accessDenied";
            }
        }
    }
}
