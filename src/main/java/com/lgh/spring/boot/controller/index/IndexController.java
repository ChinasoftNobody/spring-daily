package com.lgh.spring.boot.controller.index;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.service.login.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        MUser user = userService.login();
        model.addAttribute("user", user == null?"NA":user.getName());
        return "index";
    }
}
