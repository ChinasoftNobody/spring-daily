package com.lgh.spring.boot.service.login;


import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.developer.TokenUser;

import javax.servlet.http.HttpServletResponse;

public interface TokenService {
    /**
     * 登陆
     * @param user user
     * @return boolean
     */
    boolean userLogin(MUser user, HttpServletResponse response);

    /**
     * 登出
     * @return boolean
     */
    boolean userLogout();

    /**
     * 检查是否已有登陆
     * @param token token
     * @return result
     */
    TokenUser checkLogin(String token);

}
