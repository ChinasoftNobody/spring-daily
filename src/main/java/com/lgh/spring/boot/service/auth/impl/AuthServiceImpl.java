package com.lgh.spring.boot.service.auth.impl;

import com.alibaba.fastjson.JSONObject;
import com.lgh.spring.boot.common.AuthConf;
import com.lgh.spring.boot.common.AuthResponse;
import com.lgh.spring.boot.service.auth.AuthService;
import com.lgh.spring.boot.util.RestTemplateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/7.
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Value("{server.auth.url}")
    private String auth_url;

    @Override
    public AuthResponse validAuth(ProceedingJoinPoint joinPoint, HttpServletRequest request) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccess(false);
        if(request.getCookies() == null || request.getCookies().length == 0){
            authResponse.setMsg("cookie not found");
            return authResponse;
        }
        Cookie cookie = null;
        for (int i = 0; i < request.getCookies().length; i++) {
            Cookie c = request.getCookies()[i];
            if(c.getName().equals(AuthConf.SSO_TICKET)){
                cookie = c;
                break;
            }
        }
        if(cookie == null){
            authResponse.setMsg("cookie not found");
            return authResponse;
        }
        String ticket = cookie.getValue();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(AuthConf.SSO_TICKET,ticket);
        String remoteAuthResult = RestTemplateUtil.post(auth_url+ AuthConf.AUTH_LOGIN_STATUS_URL,jsonObject.toJSONString());
        JSONObject result = JSONObject.parseObject(remoteAuthResult);
        if(result.getString("status").equals("failed")){
            authResponse.setMsg(result.getString("result"));
            return authResponse;
        }
        if(!result.getJSONObject("result").getBoolean("access")){
            authResponse.setMsg(result.getJSONObject("result").getString("msg"));
            return authResponse;
        }
        authResponse.setAccess(true);
        authResponse.setMsg("access");
        return authResponse;
    }
}
