package com.lgh.spring.boot.mongo.model.record;

import com.lgh.spring.boot.mongo.model.MBase;
import com.lgh.spring.boot.mongo.model.MUser;
import com.lgh.spring.boot.mongo.model.module.MModule;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@Document(collection = "t_record")
public class MRecord extends MBase {
    @NotNull
    @DBRef(db = "t_module")
    private MModule module;
    @NotNull
    @DBRef(db = "t_plugin")
    private MPlugin plugin;
    private List<HashMap<String, Object>> data;
    @DBRef(db = "t_user")
    private MUser owner;

    public MPlugin getPlugin() {
        return plugin;
    }

    public void setPlugin(MPlugin plugin) {
        this.plugin = plugin;
    }

    public List<HashMap<String, Object>> getData() {
        return data;
    }

    public void setData(List<HashMap<String, Object>> data) {
        this.data = data;
    }

    public MModule getModule() {
        return module;
    }

    public void setModule(MModule module) {
        this.module = module;
    }

    public MUser getOwner() {
        return owner;
    }

    public void setOwner(MUser owner) {
        this.owner = owner;
    }
}
