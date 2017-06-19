package com.lgh.spring.boot.service.module;

import com.lgh.spring.boot.common.PageQuery;
import com.lgh.spring.boot.model.MModule;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2017/6/19.
 * 模块管理服务
 */
public interface ModuleService {
    Page<MModule> getAllModule(PageQuery query);
}
