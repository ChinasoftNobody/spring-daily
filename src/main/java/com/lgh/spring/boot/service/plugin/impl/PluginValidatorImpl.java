package com.lgh.spring.boot.service.plugin.impl;

import com.lgh.spring.boot.common.ValidatorException;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.service.plugin.PluginValidator;
import com.lgh.spring.boot.service.plugin.RecordMetaValidator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PluginValidatorImpl implements PluginValidator {
    @Resource
    private RecordMetaValidator recordMetaValidator;

    @Override
    public void validate(MPlugin plugin) throws ValidatorException {
        switch (plugin.getType()) {
            case Record:
                recordMetaValidator.validate(plugin.getMeta());
                break;
            default:
                break;
        }
    }
}
