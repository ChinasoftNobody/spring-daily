package com.lgh.spring.boot.service.login;

import com.lgh.spring.boot.model.MUser;

/**
 *
 * @author Administrator
 * @date 2017/6/22
 */
public interface UserService {
    /**
     * 查询
     * @return 第一个用户
     */
    MUser login();

}
