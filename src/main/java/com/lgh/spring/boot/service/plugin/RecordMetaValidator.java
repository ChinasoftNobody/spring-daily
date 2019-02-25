package com.lgh.spring.boot.service.plugin;

import com.lgh.spring.boot.common.ValidatorException;
import com.lgh.spring.boot.mongo.model.plugin.MPluginMeta;

public interface RecordMetaValidator {
    void validate(MPluginMeta meta) throws ValidatorException;
}
