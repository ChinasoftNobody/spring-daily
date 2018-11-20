package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.service.login.TokenService;
import com.lgh.spring.boot.service.login.UserService;
import com.lgh.spring.boot.util.ResponseUtil;
import com.lgh.spring.boot.util.UiPath;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Log LOG = LogFactory.getLog(UserController.class);
    @Resource
    private UserService userService;

    @Resource
    private TokenService tokenService;


    @PostMapping("/login")
    @ResponseBody
    public Response login(@RequestBody MUser user, HttpServletResponse response, HttpSession session) {
        MUser mUser = userService.login(user);
        if (mUser != null) {
            tokenService.userLogin(mUser, response, session);
            return ResponseUtil.success(mUser);
        } else {
            return ResponseUtil.error("登录失败");
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public Response register(@RequestBody MUser user){
        MUser mUser = userService.queryByName(user.getName());
        if (mUser != null)
        {
            return ResponseUtil.error("账号已存在");
        }
        mUser = userService.register(user);
        if (mUser == null)
        {
            return ResponseUtil.error("注册失败");
        }
        return ResponseUtil.success(mUser);
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        tokenService.userLogout(session);
        model.addAttribute("user", new MUser());
        return "redirect:/dashboard";
    }

    @GetMapping("/setting")
    public String setting(Model model){
        return UiPath.setPath(model,"/user/setting",null,"/static/js/setting/setting.js");
    }
}
