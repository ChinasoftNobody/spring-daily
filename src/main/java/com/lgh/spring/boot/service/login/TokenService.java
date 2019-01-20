package com.lgh.spring.boot.service.login;


import com.lgh.spring.boot.mongo.model.MUser;
import com.lgh.spring.boot.pojo.common.TokenUser;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface TokenService {
    /**
     * 登陆
     * @param user user
     * @param session session
     * @return boolean
     */
    boolean userLogin(MUser user, HttpServletResponse response, HttpSession session);

    /**
     * 登出
     * @return boolean
     * @param session session
     */
    boolean userLogout(HttpSession session);

    /**
     * 检查是否已有登陆
     * @param token token
     * @return result
     */
    TokenUser checkLogin(String token);

}
