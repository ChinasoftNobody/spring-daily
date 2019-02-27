package com.lgh.spring.boot.service.plugin.impl;

import com.lgh.spring.boot.common.ValidatorException;
import com.lgh.spring.boot.mongo.model.plugin.MPluginMeta;
import com.lgh.spring.boot.service.plugin.RecordMetaValidator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordMetaValidatorImpl implements RecordMetaValidator {


    @Override
    public void validate(MPluginMeta meta) throws ValidatorException {
        if (meta == null || meta.getDataFields().isEmpty()) {
            return;
        }
        List<String> fieldNames = new ArrayList<>();
        meta.getDataFields().forEach(dataField -> {
            if (fieldNames.contains(dataField.getName())) {
                throw new ValidatorException("data field duplicated");
            }
            fieldNames.add(dataField.getName());
            if (dataField.isRequired()) {
                switch (dataField.getType()) {
                    case Long:
                        try {
                            Long.valueOf(dataField.getDefaultValue());
                        } catch (Exception e) {
                            throw new ValidatorException("defaultValue type error");
                        }
                        break;
                    case String:
                        if (StringUtils.isEmpty(dataField.getDefaultValue())) {
                            throw new ValidatorException("defaultValue can not be empty");
                        }
                        break;
                    case Integer:
                        try {
                            Long.valueOf(dataField.getDefaultValue());
                        } catch (Exception e) {
                            throw new ValidatorException("defaultValue type error");
                        }
                        break;
                    default:
                        throw new ValidatorException("data field type undefined of " + dataField.getType());
                }
            }
            if (dataField.isValidated()) {
                if (StringUtils.isEmpty(dataField.getValidateRule()))
                    switch (dataField.getValidatorType()) {
                        case Match:
                            break;
                        case Regex:
                            break;
                        case Equals:
                            break;
                        case EndWith:
                            break;
                        case StartWith:
                            break;
                        default:
                            break;
                    }
            }
        });

    }

}
