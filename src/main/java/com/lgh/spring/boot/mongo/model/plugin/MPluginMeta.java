package com.lgh.spring.boot.mongo.model.plugin;

import com.lgh.spring.boot.mongo.model.MBase;
import com.lgh.spring.boot.pojo.plugin.DataField;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.List;

@Document(collection = "t_plugin_meta")
public class MPluginMeta extends MBase {
    @Valid
    private List<DataField> dataFields;

    public List<DataField> getDataFields() {
        return dataFields;
    }

    public void setDataFields(List<DataField> dataFields) {
        this.dataFields = dataFields;
    }
}
