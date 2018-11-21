package com.lgh.spring.boot.aop;

import com.alibaba.fastjson.JSON;
import com.lgh.spring.boot.common.Const;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.util.ResponseUtil;
import com.lgh.spring.boot.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if (request.getHeader("X-Requested-With") == null || !request.getHeader("X-Requested-With").equals("XMLHttpRequest")){
            //non-ajax
            String token = (String) request.getSession().getAttribute("token");
            if (StringUtils.isEmpty(token) || !TokenUtil.validateUserToken(token))
            {
                response.sendRedirect(request.getContextPath() + "/dashboard");
                return false;
            }else {
                for (Cookie cookie:request.getCookies()){
                    if (!cookie.getName().equals("token")){
                        continue;
                    }
                    if (StringUtils.isEmpty(cookie.getValue()) || !TokenUtil.validateUserToken(cookie.getValue())){
                        request.getSession().removeAttribute("token");
                        request.getSession().removeAttribute(Const.SESSION_USER_KEY);
                        response.sendRedirect(request.getContextPath() + "/dashboard");
                        return false;
                    }
                }
            }
        }else {
            //ajax
            String token = request.getHeader("token");
            if(StringUtils.isEmpty(token) || !TokenUtil.validateUserToken(token)){
                Response errorResult = ResponseUtil.error("token is empty");
                response.getOutputStream().write(JSON.toJSONString(errorResult).getBytes());
                return false;
            }
        }
        return true;
    }
}
