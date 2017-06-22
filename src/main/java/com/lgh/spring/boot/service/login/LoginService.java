package com.lgh.spring.boot.service.login;

import com.lgh.spring.boot.model.MUser;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface LoginService {
    /**
     * 登录
     *
     * @param name     用户名
     * @param password 密码
     * @return 登陆结果
     */
    MUser login(String name, String password);
}
