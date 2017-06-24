package com.lgh.spring.boot.controller.login;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.service.login.UserService;
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
@RequestMapping("/user")
@Api(tags = "user")
public class LoginController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "登录", notes = "登录")
    public Response login(@RequestBody MUser user) {
        MUser user1 = userService.login(user.getName(),user.getPassword());
        if(user1 == null){
            return ResponseUtil.failed("user not found");
        }
        return ResponseUtil.ok(user1);
    }

    @RequestMapping(value = "/register",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "注册",notes = "注册")
    public Response register(@RequestBody MUser user){
        MUser user1 = userService.register(user);
        if(user1 == null){
            return ResponseUtil.failed("注册失败");
        }
        return ResponseUtil.ok(user1);
    }
}
