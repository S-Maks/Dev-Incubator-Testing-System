package com.testing.system.service.impl;

import com.testing.system.config.DataConfig;
import com.testing.system.config.WebConfig;
import com.testing.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;


@ComponentScan(basePackages = "com.testing.system")
@ContextConfiguration(classes = {WebConfig.class, DataConfig.class})
@WebAppConfiguration
@PropertySource("classpath:db.properties")
@PropertySource("classpath:hibernate.properties")
public class UserServiceTest extends AbstractTestNGSpringContextTests {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void findAll() {
        assert (userService.findAll().size()!=0);
    }
}