package com.lgh.spring.boot.service.module.impl;

import com.lgh.spring.boot.common.PageQuery;
import com.lgh.spring.boot.model.MModule;
import com.lgh.spring.boot.repo.ModuleRepo;
import com.lgh.spring.boot.service.module.ModuleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/19.
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Resource
    private ModuleRepo moduleRepo;

    @Override
    public Page<MModule> getAllModule(PageQuery query) {
        Page<MModule> modules = moduleRepo.findAll(query);
        return modules;
    }
}
