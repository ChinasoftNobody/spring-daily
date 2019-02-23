package com.lgh.spring.boot.mongo.model.module;

import com.lgh.spring.boot.mongo.model.MBase;
import com.lgh.spring.boot.pojo.module.ModuleType;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection = "t_module")
public class MModule extends MBase {
    @NotEmpty
    private String name;
    private String desc;
    @NotNull
    private ModuleType type;


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
}
