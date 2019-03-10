package com.lgh.spring.boot.pojo.plugin;

import javax.validation.Valid;
import java.util.List;

public class PluginMeta {
    @Valid
    private List<DataField> dataFields;

    public List<DataField> getDataFields() {
        return dataFields;
    }

    public void setDataFields(List<DataField> dataFields) {
        this.dataFields = dataFields;
    }
}
