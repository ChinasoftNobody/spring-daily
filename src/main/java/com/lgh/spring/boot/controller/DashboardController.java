package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.common.Const;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.service.login.UserService;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "redirect:dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        MUser mUser = (MUser) session.getAttribute(Const.SESSION_USER_KEY);
        Boolean login = (Boolean) session.getAttribute("login");
        if (login == null || !login) {
            mUser = new MUser();
            login = false;
        }
        model.addAttribute("user", mUser);
        model.addAttribute("login", login);
        return UiPath.setPath(model,"dashboard",null,"/static/js/user/user.js");
    }
}