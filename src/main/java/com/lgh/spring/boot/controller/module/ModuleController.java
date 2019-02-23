package com.lgh.spring.boot.controller.module;

import com.lgh.spring.boot.mongo.model.module.MModule;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.module.FindModuleRequest;
import com.lgh.spring.boot.service.module.ModuleService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 模块管理
 */
@RestController
@RequestMapping("/module")
public class ModuleController {

    @Resource
    private ModuleService moduleService;

    @PostMapping("/findAll")
    public Response findAll(@RequestBody @Validated FindModuleRequest request){
        return ResponseUtil.success(moduleService.findAll(request));
    }

    @PostMapping("/create")
    public Response create(@RequestBody @Validated MModule module){
        module = moduleService.create(module);
        return ResponseUtil.success(module);
    }

    @PostMapping("/update")
    public Response update(@RequestBody @Validated MModule module){
        if (StringUtils.isEmpty(module.getId())){
            return ResponseUtil.error("Id is null");
        }
        return ResponseUtil.success(moduleService.update(module));
    }

    @PostMapping("/delete")
    public Response delete(@RequestBody @Validated MModule module){
        if (StringUtils.isEmpty(module.getId())){
            return ResponseUtil.error("Id is null");
        }
        return ResponseUtil.success(moduleService.delete(module));
    }
}
