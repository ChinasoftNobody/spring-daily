package com.lgh.spring.boot.service.login.impl;

import com.lgh.spring.boot.mapper.UserMapper;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.service.login.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public MUser login() {
        return userMapper.first();
    }
}
