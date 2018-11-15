package com.lgh.spring.boot.mapper;

import com.lgh.spring.boot.model.MUserModule;
import org.apache.ibatis.annotations.Param;

public interface UserModuleMapper {

    /**
     * 添加用户模块关联
     * @param userModule userModule
     * @return 影响行数
     */
    int insert(@Param("userModule") MUserModule userModule);
}
