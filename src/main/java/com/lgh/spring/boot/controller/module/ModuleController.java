package com.lgh.spring.boot.controller.module;

import com.lgh.spring.boot.mongo.model.module.MModule;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.module.FindModuleRequest;
import com.lgh.spring.boot.pojo.module.QueryByIdRequest;
import com.lgh.spring.boot.service.module.ModuleService;
import com.lgh.spring.boot.service.plugin.PluginService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 模块管理
 */
@RestController
@RequestMapping("/module")
public class ModuleController {

    @Resource
    private ModuleService moduleService;
    @Resource
    private PluginService pluginService;

    @PostMapping("/findAll")
    public Response<Page<MModule>> findAll(@RequestBody @Validated FindModuleRequest request) {
        return ResponseUtil.success(moduleService.findAll(request));
    }

    @PostMapping("/create")
    public Response<MModule> create(@RequestBody @Validated MModule module) {
        module = moduleService.create(module);
        return ResponseUtil.success(module);
    }

    @PostMapping("/update")
    public Response<MModule> update(@RequestBody @Validated MModule module) {
        if (StringUtils.isEmpty(module.getId())) {
            return ResponseUtil.error("Id is null");
        }
        return ResponseUtil.success(moduleService.update(module));
    }

    @PostMapping("/delete")
    public Response<Boolean> delete(@RequestBody @Validated MModule module) {
        if (StringUtils.isEmpty(module.getId())) {
            return ResponseUtil.error("Id is null");
        }
        return ResponseUtil.success(moduleService.delete(module));
    }

    @PostMapping("/queryById")
    public Response<MModule> queryById(@RequestBody @Validated QueryByIdRequest request) {
        Optional<MModule> moduleOptional = moduleService.findById(request.getId());
        return moduleOptional.map(ResponseUtil::success).orElseGet(() -> ResponseUtil.error("not found"));
    }

    @PostMapping("/queryPluginsByModuleId")
    public Response<List<MPlugin>> queryPluginsByModuleId(@RequestBody @Validated QueryByIdRequest request){
        return ResponseUtil.success(pluginService.queryByModuleId(request.getId()));
    }


}
