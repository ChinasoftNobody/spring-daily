package com.lgh.spring.boot.controller.plugin;

import com.lgh.spring.boot.enums.DataFieldType;
import com.lgh.spring.boot.enums.PluginType;
import com.lgh.spring.boot.enums.ValidatorType;
import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.plugin.FindAllRequest;
import com.lgh.spring.boot.service.plugin.PluginService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;

/**
 * 插件管理
 */
@RestController
@RequestMapping("/plugin")
public class PluginController {
    @Resource
    private PluginService pluginService;

    @PostMapping("/findAll")
    public Response<Page<MPlugin>> findAll(@RequestBody @Validated FindAllRequest request) {
        return ResponseUtil.success(pluginService.findAll(request));
    }

    @PostMapping("/create")
    public Response<MPlugin> create(@RequestBody @Validated MPlugin plugin) {
        return pluginService.create(plugin);
    }

    @PostMapping("/delete")
    public Response<String> delete(@RequestBody String id) {
        pluginService.delete(id);
        return ResponseUtil.success("ok");
    }

    @PostMapping("/queryTypes")
    public Response queryTypes() {
        return ResponseUtil.success(PluginType.values());
    }

    @PostMapping("/queryPluginById")
    public Response<MPlugin> queryPluginById(@RequestBody @Validated @NotEmpty String id) {
        MPlugin result = pluginService.queryPluginById(id);
        if (result == null) {
            return ResponseUtil.error("not found this plugin");
        }
        return ResponseUtil.success(result);
    }

    @PostMapping("/update")
    public Response<MPlugin> update(@RequestBody @Validated MPlugin plugin) {
        return ResponseUtil.success(pluginService.update(plugin));
    }

    @PostMapping("/queryFieldType")
    public Response<DataFieldType[]> queryFieldType() {
        return ResponseUtil.success(DataFieldType.values());
    }

    @PostMapping("/queryValidatorType")
    public Response<ValidatorType[]> queryValidatorType() {
        return ResponseUtil.success(ValidatorType.values());
    }
}
