package com.lgh.spring.boot.util;

import com.lgh.spring.boot.common.Const;
import com.lgh.spring.boot.pojo.developer.SessionUser;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static boolean validateUserLogin(HttpSession session){
        if (session == null){
            return false;
        }
        Object user = session.getAttribute(Const.SESSION_USER_KEY);
        return user != null && user instanceof SessionUser;
    }

    public static SessionUser getUser(HttpSession session) {
        if (session == null){
            return null;
        }
        Object user = session.getAttribute(Const.SESSION_USER_KEY);
        if (user == null || ! (user instanceof SessionUser)){
            return null;
        }
        return (SessionUser) user;
    }
}
