package com.lgh.spring.boot.service.plugin;

import com.lgh.spring.boot.common.ValidatorException;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;

public interface PluginValidator {
    void validate(MPlugin plugin) throws ValidatorException;
}
