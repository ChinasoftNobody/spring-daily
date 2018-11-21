package com.lgh.spring.boot.service.module.impl;

import com.lgh.spring.boot.mapper.ModuleMapper;
import com.lgh.spring.boot.mapper.UserModuleMapper;
import com.lgh.spring.boot.model.MModule;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.model.MUserModule;
import com.lgh.spring.boot.pojo.developer.TokenUser;
import com.lgh.spring.boot.service.login.UserService;
import com.lgh.spring.boot.service.module.ModuleService;
import com.lgh.spring.boot.util.TokenUtil;
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
    private UserModuleMapper userModuleMapper;

    @Resource
    private UserService userService;

    @Override
    public List<MModule> queryCurrentUserModules() {
        TokenUser tokenUser = TokenUtil.getCurrentUser();
        if (tokenUser == null){
            return null;
        }
        String id = tokenUser.getId();
        if (StringUtils.isEmpty(id))
        {
            return null;
        }
        return moduleMapper.queryByUserId(id);
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
        if (!moduleMapper.insert(module))
        {
            return null;
        }
        MUserModule mUserModule = new MUserModule();
        mUserModule.setUserId(id);
        mUserModule.setModuleId(module.getId());
        userModuleMapper.insert(mUserModule);
        return module;
    }

    @Override
    public MModule addCurrentModule(MModule module) {
        TokenUser tokenUser = TokenUtil.getCurrentUser();
        if (tokenUser == null){
            return null;
        }
        MModule mModule = addModule(module, tokenUser.getId());
        if (StringUtils.isEmpty(mModule.getId())){
            return null;
        }
        return mModule;
    }
}
