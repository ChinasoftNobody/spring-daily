package com.lgh.spring.boot.controller.index;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.service.login.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(@ModelAttribute MUser user, Model model, HttpSession session) {
        MUser mUser = userService.login(user);
        if (user != null && mUser!=null)
        {
            session.setAttribute("user", mUser);
            session.setAttribute("login", true);
            model.addAttribute("user", mUser);
            model.addAttribute("login", true);
        }else {
            user = new MUser();
            model.addAttribute("user", user);
            model.addAttribute("login", false);
            model.addAttribute("user", new MUser());
            model.addAttribute("login", false);
        }
        return "/dashboard";
    }
}
