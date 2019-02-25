package com.lgh.spring.boot.controller.plugin;

import com.lgh.spring.boot.mongo.model.plugin.MPlugin;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.service.plugin.PluginService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 插件管理
 */
@RestController
@RequestMapping("/plugin")
public class PluginController {
    @Resource
    private PluginService pluginService;

    @PostMapping("/findAll")
    public Response findAll(){
        return ResponseUtil.success(pluginService.findAll());
    }
    @PostMapping("/create")
    public Response create(@RequestBody @Validated MPlugin plugin){
        return pluginService.create(plugin);
    }
    @PostMapping("/delete")
    public Response delete(@RequestBody String id){
        pluginService.delete(id);
        return ResponseUtil.success("ok");
    }
}
