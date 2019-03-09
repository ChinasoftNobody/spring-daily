package com.lgh.spring.boot.service.plugin;

import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.plugin.FindAllRequest;
import org.springframework.data.domain.Page;

import java.util.List;

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
    Response<MPlugin> create(MPlugin plugin);

    /**
     * 根据ID删除插件
     * @param id id
     */
    void delete(String id);

    /**
     * 根据ID查询插件信息
     * @param id id
     * @return result
     */
    MPlugin queryPluginById(String id);

    /**
     * update
     * @param plugin plugin
     * @return result
     */
    MPlugin update(MPlugin plugin);

    /**
     * queryByModuleId
     * @param id id
     * @return result
     */
    List<MPlugin> queryByModuleId(String id);
}
