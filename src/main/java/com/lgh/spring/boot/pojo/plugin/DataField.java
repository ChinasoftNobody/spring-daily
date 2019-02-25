package com.lgh.spring.boot.pojo.plugin;

import com.lgh.spring.boot.enums.DataFieldType;
import com.lgh.spring.boot.enums.ValidatorType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DataField {
    @NotEmpty
    private String name;
    @NotNull
    private DataFieldType type;
    private String defaultValue;
    @NotNull
    private boolean required;
    @NotNull
    private ValidatorType validatorType;
    @NotNull
    private boolean validated;
    @NotNull
    private String validateRule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataFieldType getType() {
        return type;
    }

    public void setType(DataFieldType type) {
        this.type = type;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getValidateRule() {
        return validateRule;
    }

    public void setValidateRule(String validateRule) {
        this.validateRule = validateRule;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public ValidatorType getValidatorType() {
        return validatorType;
    }

    public void setValidatorType(ValidatorType validatorType) {
        this.validatorType = validatorType;
    }
}
