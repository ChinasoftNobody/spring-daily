package com.lgh.spring.boot.service.plugin.impl;

import com.lgh.spring.boot.common.ValidatorException;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.mongo.repo.PluginRepo;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.plugin.FindAllRequest;
import com.lgh.spring.boot.service.plugin.PluginService;
import com.lgh.spring.boot.service.plugin.PluginValidator;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class PluginServiceImpl implements PluginService {
    @Resource
    private PluginRepo pluginRepo;
    @Resource
    private PluginValidator pluginValidatorImpl;

    @Override
    public Page<MPlugin> findAll(FindAllRequest request) {
        PageRequest pageable = PageRequest.of(request.getPage(), request.getSize());
        if (StringUtils.isEmpty(request.getKeyword())){
            return pluginRepo.findAll(pageable);
        }
        return pluginRepo.findByNameContainingOrDescContaining(request.getKeyword(), pageable);
    }

    @Override
    public Response create(MPlugin plugin) {
        try {
            if (plugin.getMeta() != null){
                plugin.getMeta().generateBaseInfo();
            }
            plugin.generateBaseInfo();
            pluginValidatorImpl.validate(plugin);
            return ResponseUtil.success(pluginRepo.save(plugin));
        }catch (ValidatorException e){
            return ResponseUtil.error(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        pluginRepo.deleteById(id);
    }
}