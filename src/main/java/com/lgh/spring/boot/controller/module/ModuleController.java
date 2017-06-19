package com.lgh.spring.boot.controller.module;

import com.lgh.spring.boot.common.PageQuery;
import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.service.module.ModuleService;
import com.lgh.spring.boot.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/19.
 */
@RestController
@RequestMapping("/module")
@Api(tags = "module")
public class ModuleController {
    @Resource
    private ModuleService moduleService;

    @PostMapping(value = "/query",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页查询模块列表",notes = "分页查询模块列表")
    public Response getModules(@RequestBody PageQuery pageQuery){
        return ResponseUtil.ok(moduleService.getAllModule(pageQuery));
    }
}
