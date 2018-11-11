package com.lgh.spring.boot.controller.index;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.developer.SessionUser;
import com.lgh.spring.boot.service.login.SessionService;
import com.lgh.spring.boot.service.login.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Log LOG = LogFactory.getLog(UserController.class);
    @Resource
    private UserService userService;

    @Resource
    private SessionService sessionService;


    @PostMapping("/login")
    public String login(@ModelAttribute MUser user, Model model, HttpSession session) {
        SessionUser sessionUser = sessionService.checkLogin(session);
        if (sessionUser != null) {
            model.addAttribute("user", user);
            LOG.info("无需登录");
            return "redirect:/dashboard";
        }
        MUser mUser = userService.login(user);
        if (mUser != null) {
            sessionService.userLogin(session, mUser);
            user = mUser;
        } else {
            user = new MUser();
        }
        model.addAttribute("user", user);
        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        sessionService.userLogout(session);
        model.addAttribute("user", new MUser());
        return "/dashboard";
    }
}
