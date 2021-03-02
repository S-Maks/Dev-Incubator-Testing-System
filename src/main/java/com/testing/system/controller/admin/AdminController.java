package com.testing.system.controller.admin;

import com.testing.system.model.User;
import com.testing.system.service.RoleService;
import com.testing.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String adminPage() {
        return "admin/admin";
    }

    @GetMapping("/createUser")
    public String createUserPage(Model model){
        model.addAttribute("roles", roleService.findAll());
        return "admin/createUser";
    }

    @PostMapping("/createUser")
    public String createUserPage(User user, int roleId){
        userService.save(user, roleId);
        return "redirect:/admin";
    }
}
