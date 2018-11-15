package com.lgh.spring.boot.service.module.impl;

import com.lgh.spring.boot.mapper.ModuleMapper;
import com.lgh.spring.boot.model.MModule;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.model.MUserModule;
import com.lgh.spring.boot.service.login.UserService;
import com.lgh.spring.boot.service.module.ModuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

    @Resource
    private ModuleMapper moduleMapper;

    @Resource
    private UserService userService;

    @Override
    public List<MModule> queryUserModules(String userId) {
        if (StringUtils.isEmpty(userId))
        {
            return null;
        }
        return moduleMapper.queryByUserId(userId);
    }

    @Override
    public MModule addModule(MModule module, String id) {
        if (module == null || StringUtils.isEmpty(module.getName()))
        {
            return null;
        }
        MUser mUser = userService.queryById(id);
        if (mUser == null)
        {
            return null;
        }
        if (moduleMapper.insert(module))
        {
            return null;
        }
        MUserModule mUserModule = new MUserModule();
        mUserModule.setUserId(id);
        mUserModule.setModuleId(module.getId());

        return module;
    }
}
