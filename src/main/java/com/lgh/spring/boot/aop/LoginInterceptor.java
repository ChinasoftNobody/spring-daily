package com.lgh.spring.boot.aop;

import com.lgh.spring.boot.util.SessionUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if (!SessionUtil.validateUserLogin(request.getSession())){
            response.sendRedirect(request.getContextPath() + "/dashboard");
            return false;
        }
        return true;
    }
}
