package com.lgh.spring.boot.service.login.impl;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.repo.UserRepo;
import com.lgh.spring.boot.service.login.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/22.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserRepo userRepo;

    @Override
    public MUser login(String name, String password) {
        return userRepo.findByNameAndPassword(name, password);
    }
}
