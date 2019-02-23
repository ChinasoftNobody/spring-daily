package com.lgh.spring.boot.service.module;

import com.lgh.spring.boot.mongo.model.module.MModule;
import com.lgh.spring.boot.pojo.module.FindModuleRequest;
import org.springframework.data.domain.Page;

public interface ModuleService {
    /**
     * findAll
     * @param request request
     * @return result
     */
    Page<MModule> findAll(FindModuleRequest request);

    /**
     * 创建模块
     * @param module module
     * @return result
     */
    MModule create(MModule module);

    /**
     * 更新模块
     * @param module module
     * @return result
     */
    MModule update(MModule module);

    /**
     * 删除模块
     * @param module module
     */
    boolean delete(MModule module);
}
