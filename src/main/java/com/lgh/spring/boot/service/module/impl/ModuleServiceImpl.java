package com.lgh.spring.boot.service.module.impl;

import com.lgh.spring.boot.mongo.model.module.MModule;
import com.lgh.spring.boot.mongo.repo.ModuleRepo;
import com.lgh.spring.boot.mongo.repo.PluginRepo;
import com.lgh.spring.boot.pojo.module.FindModuleRequest;
import com.lgh.spring.boot.service.module.ModuleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Resource
    private ModuleRepo moduleRepo;
    @Resource
    private PluginRepo pluginRepo;

    @Override
    public Page<MModule> findAll(FindModuleRequest request) {
        return moduleRepo.findByNameContaining(request.getKeyword(), PageRequest.of(request.getPage(), request.getSize()));
    }

    @Override
    public MModule create(MModule module) {
        if (StringUtils.isEmpty(module.getId())){
            module.generateBaseInfo();
        }
        return update(module);
    }

    @Override
    public MModule update(MModule module) {
        if (!module.getPlugins().isEmpty()){
            module.getPlugins().forEach(plugin -> {
                if (StringUtils.isEmpty(plugin.getId())){
                    plugin.generateBaseInfo();
                }
            });
            pluginRepo.saveAll(module.getPlugins());
        }
        return moduleRepo.save(module);
    }

    @Override
    public boolean delete(MModule module) {
        moduleRepo.deleteById(module.getId());
        return true;
    }

    @Override
    public Optional<MModule> findById(String id) {
        return moduleRepo.findById(id);
    }
}
