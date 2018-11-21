package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.model.MModule;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.developer.TokenUser;
import com.lgh.spring.boot.service.module.ModuleService;
import com.lgh.spring.boot.util.ResponseUtil;
import com.lgh.spring.boot.util.TokenUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Resource
    private ModuleService moduleService;

    @GetMapping("/modules")
    public Response queryModule() {
        List<MModule> modules = moduleService.queryCurrentUserModules();
        if (modules == null) {
            modules = Collections.emptyList();
        }
        return ResponseUtil.success(modules);
    }

    @PostMapping("/add")
    public Response addModule(@RequestBody MModule module, @RequestHeader("token") String token) {
        if (TokenUtil.validateUserToken(token)) {
            return ResponseUtil.error("empty session");
        }
        TokenUser tokenUser = TokenUtil.getUser(token);
        module = moduleService.addModule(module, tokenUser.getId());
        if (module == null)
        {
            return ResponseUtil.error("add module failed");
        }
        return ResponseUtil.success(module);
    }
}
