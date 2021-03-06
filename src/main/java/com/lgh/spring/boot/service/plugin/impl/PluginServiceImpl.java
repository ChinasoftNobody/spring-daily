package com.lgh.spring.boot.service.plugin.impl;

import com.lgh.spring.boot.common.ValidatorException;
import com.lgh.spring.boot.mongo.model.module.MModule;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.pojo.plugin.PluginMeta;
import com.lgh.spring.boot.mongo.repo.ModuleRepo;
import com.lgh.spring.boot.mongo.repo.PluginMetaRepo;
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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PluginServiceImpl implements PluginService {
    @Resource
    private PluginRepo pluginRepo;
    @Resource
    private ModuleRepo moduleRepo;
    @Resource
    private PluginMetaRepo pluginMetaRepo;
    @Resource
    private PluginValidator pluginValidatorImpl;

    @Override
    public Page<MPlugin> findAll(FindAllRequest request) {
        PageRequest pageable = PageRequest.of(request.getPage(), request.getSize());
        if (StringUtils.isEmpty(request.getKeyword())) {
            return pluginRepo.findAll(pageable);
        }
        return pluginRepo.findByNameContainingOrDescContaining(request.getKeyword(), pageable);
    }

    @Override
    public Response<MPlugin> create(MPlugin plugin) {
        try {
            if (plugin.getMeta() == null){
                PluginMeta meta = new PluginMeta();
                meta.setDataFields(Collections.emptyList());
                plugin.setMeta(meta);
            }
            plugin.generateBaseInfo();
            pluginValidatorImpl.validate(plugin);
            return ResponseUtil.success(pluginRepo.save(plugin));
        } catch (ValidatorException e) {
            return ResponseUtil.error(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        pluginRepo.deleteById(id);
    }

    @Override
    public MPlugin queryPluginById(String id) {
        Optional<MPlugin> plugin = pluginRepo.findById(id);
        plugin.ifPresent(plugin1 -> {
            if (plugin1.getMeta() == null){
                PluginMeta meta = new PluginMeta();
                meta.setDataFields(Collections.emptyList());
                plugin1.setMeta(meta);
            }
        });
        return plugin.orElse(null);
    }

    @Override
    public MPlugin update(MPlugin plugin) {
        return pluginRepo.save(plugin);
    }

    @Override
    public List<MPlugin> queryByModuleId(String id) {
        return moduleRepo.findById(id).orElse(new MModule()).getPlugins();
    }
}
