package com.lgh.spring.boot.mongo.model.module;

import com.lgh.spring.boot.enums.ModuleType;
import com.lgh.spring.boot.mongo.model.MBase;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Document(collection = "t_module")
public class MModule extends MBase {
    @NotEmpty
    private String name;
    @NotEmpty
    private String desc;
    @NotNull
    private ModuleType type;
    @DBRef
    private List<MPlugin> plugins = Collections.emptyList();

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

    public ModuleType getType() {
        return type;
    }

    public void setType(ModuleType type) {
        this.type = type;
    }

    public List<MPlugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<MPlugin> plugins) {
        this.plugins = plugins;
    }
}
