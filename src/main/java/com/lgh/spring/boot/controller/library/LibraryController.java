package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.service.login.UserService;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * library management
 */
@Controller
@RequestMapping("/library")
public class LibraryController {
    @Resource
    private UserService userService;

    @GetMapping("")
    public String index(Model model){

        return UiPath.setPath(model, "/library/index");
    }
}
