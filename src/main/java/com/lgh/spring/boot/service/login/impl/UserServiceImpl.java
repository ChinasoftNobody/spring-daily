package com.lgh.spring.boot.service.login.impl;


import com.lgh.spring.boot.mongo.model.MUser;
import com.lgh.spring.boot.mongo.repo.UserRepo;
import com.lgh.spring.boot.service.login.UserService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepo userRepo;

    @Override
    public MUser login(MUser user) {
        return userRepo.findOne(Example.of(user)).orElse(null);
    }

    @Override
    public MUser queryByName(String name) {
        return null;
    }

    @Override
    public MUser register(MUser user) {
        return userRepo.insert(user);
    }

    @Override
    public MUser queryById(int id) {
        Optional<MUser> mUser = userRepo.findById(id);
        return mUser.orElse(null);
    }

    @Override
    public List<MUser> queryAll() {
        return userRepo.findAll();
    }
}
