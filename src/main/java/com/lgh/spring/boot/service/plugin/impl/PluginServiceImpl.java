package com.lgh.spring.boot.service.plugin.impl;

import com.lgh.spring.boot.common.ValidatorException;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.mongo.repo.PluginRepo;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.service.plugin.PluginService;
import com.lgh.spring.boot.service.plugin.PluginValidator;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PluginServiceImpl implements PluginService {
    @Resource
    private PluginRepo pluginRepo;
    @Resource
    private PluginValidator pluginValidatorImpl;

    @Override
    public List<MPlugin> findAll() {
        return pluginRepo.findAll();
    }

    @Override
    public Response create(MPlugin plugin) {
        try {
            plugin.getMeta().generateBaseInfo();
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
