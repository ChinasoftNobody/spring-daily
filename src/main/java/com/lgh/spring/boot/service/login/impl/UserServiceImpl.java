package com.lgh.spring.boot.service.login.impl;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.repo.UserRepo;
import com.lgh.spring.boot.service.login.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepo userRepo;

    @Override
    public MUser login(String name, String password) {
        return userRepo.findByNameAndPassword(name, password);
    }

    @Override
    public MUser register(MUser user) {
        if(StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())){
            return null;
        }
        return userRepo.save(user);
    }
}
