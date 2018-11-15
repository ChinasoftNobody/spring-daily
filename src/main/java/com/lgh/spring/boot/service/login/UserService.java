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
     * @param user
     */
    MUser login(MUser user);

    /**
     *
     * @param name name
     * @return result
     */
    MUser queryByName(String name);

    /**
     * 注册
     * @param user user
     * @return user
     */
    MUser register(MUser user);

    /**
     * 查询
     * @param id id
     * @return user
     */
    MUser queryById(String id);
}
