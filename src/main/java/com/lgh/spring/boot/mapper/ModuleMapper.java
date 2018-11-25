package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MModule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapper {

    /**
     * 根据用户ID查询模块信息
     * @param userId 用户ID
     * @return 模块列表
     */
    List<MModule> queryByUserId(@Param("userId") int userId);

    /**
     * 新增模块
     * @param module 模块
     * @return 结果
     */
    boolean insert(@Param("module") MModule module);
}
