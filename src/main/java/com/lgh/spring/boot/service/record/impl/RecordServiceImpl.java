package com.lgh.spring.boot.service.record.impl;

import com.lgh.spring.boot.enums.PluginType;
import com.lgh.spring.boot.exception.ServerException;
import com.lgh.spring.boot.mongo.model.module.MModule;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.mongo.model.record.MRecord;
import com.lgh.spring.boot.mongo.repo.ModuleRepo;
import com.lgh.spring.boot.mongo.repo.RecordRepo;
import com.lgh.spring.boot.service.record.RecordService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    private RecordRepo recordRepo;
    @Resource
    private ModuleRepo moduleRepo;

    @Override
    public List<MRecord> findByModuleId(String id) {
        Optional<MModule> module = moduleRepo.findById(id);
        if (module.isEmpty() || module.get().getPlugins().isEmpty()) {
            return Collections.emptyList();
        }
        List<MPlugin> plugins = module.get().getPlugins().stream()
                .filter(plugin -> plugin.getType().equals(PluginType.Record)).collect(Collectors.toList());
        if (plugins.isEmpty()) {
            return Collections.emptyList();
        }
        List<MRecord> records = new ArrayList<>();
        plugins.forEach(plugin -> records.addAll(recordRepo.findByModuleAndPlugin(module.get(), plugin)));
        return records;
    }

    @Override
    public MRecord update(MRecord record) throws ServerException {
        if (StringUtils.isEmpty(record.getId())) {
            record.generateBaseInfo();
        }
        if (record.getPlugin().getMeta() == null || record.getPlugin().getMeta().getDataFields().isEmpty()) {
            throw new ServerException("meta info err");
        }
        return recordRepo.save(record);
    }
}
