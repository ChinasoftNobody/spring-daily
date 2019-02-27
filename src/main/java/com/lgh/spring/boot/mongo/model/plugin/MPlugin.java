package com.lgh.spring.boot.mongo.model.plugin;

import com.lgh.spring.boot.enums.PluginType;
import com.lgh.spring.boot.mongo.model.MBase;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection = "t_plugin")
public class MPlugin extends MBase {
    @NotEmpty
    @Indexed(unique = true)
    private String name;
    @NotEmpty
    private String desc;
    @NotNull
    private PluginType type;

    private MPluginMeta meta;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PluginType getType() {
        return type;
    }

    public void setType(PluginType type) {
        this.type = type;
    }

    public MPluginMeta getMeta() {
        return meta;
    }

    public void setMeta(MPluginMeta meta) {
        this.meta = meta;
    }

}
