package com.lgh.spring.boot.util;

import com.alibaba.fastjson.JSON;
import com.lgh.spring.boot.pojo.developer.TokenUser;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class TokenUtil {

    public static boolean validateUserToken(String token) {
        TokenUser tokenUser = decodeToken(token.replace("%3D","="));
        return tokenUser != null;
    }

    public static TokenUser getUser(String token) {
        return decodeToken(token);
    }

    public static String encodeToken(TokenUser tokenUser) {
        if (tokenUser == null){
            return null;
        }
        String userStr = JSON.toJSONString(tokenUser);
        return CipherUtil.base64Encode(userStr);
    }

    public static TokenUser decodeToken(String token) {
        if (StringUtils.isEmpty(token)){
            return null;
        }
        try {
            String decode = CipherUtil.base64Decode(token);
            return JSON.toJavaObject(JSON.parseObject(decode), TokenUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TokenUser getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String token;
        if (request.getHeader("X-Requested-With") == null || !request.getHeader("X-Requested-With").equals("XMLHttpRequest")){
            //non-ajax
            token = request.getSession().getAttribute("token").toString();
            if (StringUtils.isEmpty(token)){
                for (Cookie cookie: request.getCookies()){
                    if (cookie.getName().equals("token") && !StringUtils.isEmpty(cookie.getValue())){
                        token = cookie.getValue();
                        break;
                    }
                }
            }
            if (StringUtils.isEmpty(token)) {
                return null;
            }
            return decodeToken(token);
        }else {
            //ajax
            token = request.getHeader("token");
            if (StringUtils.isEmpty(token)){
                return null;
            }
            return decodeToken(token);
        }
    }
}
