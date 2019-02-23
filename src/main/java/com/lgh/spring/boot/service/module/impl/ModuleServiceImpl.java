package com.lgh.spring.boot.service.module.impl;

import com.lgh.spring.boot.mongo.model.module.MModule;
import com.lgh.spring.boot.mongo.repo.ModuleRepo;
import com.lgh.spring.boot.pojo.module.FindModuleRequest;
import com.lgh.spring.boot.service.module.ModuleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Resource
    private ModuleRepo moduleRepo;

    @Override
    public Page<MModule> findAll(FindModuleRequest request) {
        return moduleRepo.findByNameContaining(request.getKeyword(), PageRequest.of(request.getPage(), request.getSize()));
    }

    @Override
    public MModule create(MModule module) {
        return moduleRepo.save(module);
    }

    @Override
    public MModule update(MModule module) {
        return moduleRepo.save(module);
    }

    @Override
    public boolean delete(MModule module) {
        moduleRepo.deleteById(module.getId());
        return true;
    }
}
