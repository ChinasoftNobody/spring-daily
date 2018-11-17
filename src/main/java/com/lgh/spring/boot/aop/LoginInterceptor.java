package com.lgh.spring.boot.aop;

import com.alibaba.fastjson.JSON;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.util.ResponseUtil;
import com.lgh.spring.boot.util.TokenUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if (request.getMethod().equals(HttpMethod.GET.name())){
            return true;
        }
        if (!TokenUtil.validateUserToken(request.getHeader("token"))){
            if (request.getHeader("X-Requested-With") == null || !request.getHeader("X-Requested-With").equals("XMLHttpRequest")){
                response.sendRedirect(request.getContextPath() + "/dashboard");
            }else {
                Response errorResult = ResponseUtil.error("token is empty");
                response.getOutputStream().write(JSON.toJSONString(errorResult).getBytes());
            }
            return false;
        }
        return true;
    }
}
