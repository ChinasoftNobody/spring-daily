package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.service.login.UserService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DashboardController {

    @Resource
    private UserService userService;

}
