package com.lgh.spring.boot.service.login;


import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.developer.SessionUser;

import javax.servlet.http.HttpSession;

public interface SessionService {
    /**
     * 登陆
     * @param session session
     * @param user user
     * @return boolean
     */
    boolean userLogin(HttpSession session, MUser user);

    /**
     * 登出
     * @param session session
     * @return boolean
     */
    boolean userLogout(HttpSession session);

    /**
     * 检查是否已有登陆
     * @param session session
     * @return result
     */
    SessionUser checkLogin(HttpSession session);
}
