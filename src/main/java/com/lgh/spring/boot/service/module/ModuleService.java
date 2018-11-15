package com.lgh.spring.boot.service.module;

import com.lgh.spring.boot.model.MModule;

import java.util.List;

public interface ModuleService {

    /**
     * 根据用户ID查询模块列表
     * @param userId 用户ID
     * @return 模块列表
     */
    List<MModule> queryUserModules(String userId);

    /**
     * 添加模块
     * @param module module
     * @param id 用户ID
     * @return 添加的模块
     */
    MModule addModule(MModule module, String id);
}
