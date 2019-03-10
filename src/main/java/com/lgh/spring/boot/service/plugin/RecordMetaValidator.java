package com.lgh.spring.boot.service.plugin;

import com.lgh.spring.boot.common.ValidatorException;
import com.lgh.spring.boot.pojo.plugin.PluginMeta;

public interface RecordMetaValidator {
    void validate(PluginMeta meta) throws ValidatorException;
}
