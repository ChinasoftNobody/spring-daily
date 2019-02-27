package com.lgh.spring.boot.service.plugin;

import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.plugin.FindAllRequest;
import org.springframework.data.domain.Page;

public interface PluginService {
    /**
     * 查询插件列表
     * @param request request
     * @return result
     */
    Page<MPlugin> findAll(FindAllRequest request);

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