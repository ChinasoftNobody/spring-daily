package com.lgh.spring.boot.controller.login;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.service.login.LoginService;
import com.lgh.spring.boot.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/22.
 */
@RestController
@RequestMapping("/login")
@Api(tags = "login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "登录", notes = "登录")
    public Response login(@RequestBody MUser user) {
        MUser user1 = loginService.login(user.getName(),user.getPassword());
        if(user1 == null){
            return ResponseUtil.failed("user not found");
        }
        return ResponseUtil.ok(user1);
    }
}
