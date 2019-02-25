package com.lgh.spring.boot.service.plugin;

import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.pojo.common.Response;

import java.util.List;

public interface PluginService {
    /**
     * 查询插件列表
     * @return result
     */
    List<MPlugin> findAll();

    /**
     * 创建插件信息
     * @param plugin plugin
     * @return result
     */
    Response create(MPlugin plugin);

    /**
     * 根据ID删除插件
     * @param id id
     */
    void delete(String id);
}
