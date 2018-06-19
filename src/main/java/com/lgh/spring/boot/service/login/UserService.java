package com.lgh.spring.boot.service.login;

import com.lgh.spring.boot.model.MUser;

/**
 *
 * @author Administrator
 * @date 2017/6/22
 */
public interface UserService {
    /**
     * 登录
     *
     * @param name     用户名
     * @param password 密码
     * @return 登陆结果
     */
    MUser login(String name, String password);

    /**
     * 注册
     * @param user 用户信息
     * @return 结果
     */
    MUser register(MUser user);
}
