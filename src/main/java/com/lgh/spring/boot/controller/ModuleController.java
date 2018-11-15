package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.model.MModule;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.developer.SessionUser;
import com.lgh.spring.boot.service.module.ModuleService;
import com.lgh.spring.boot.util.ResponseUtil;
import com.lgh.spring.boot.util.SessionUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Resource
    private ModuleService moduleService;

    @GetMapping("/modules")
    public Response queryModule(HttpSession session) {
        if (SessionUtil.validateUserLogin(session)) {
            return ResponseUtil.error("empty session");
        }
        SessionUser sessionUser = SessionUtil.getUser(session);
        String id = sessionUser.getId();
        List<MModule> modules = moduleService.queryUserModules(id);
        if (modules == null) {
            modules = Collections.emptyList();
        }
        return ResponseUtil.success(modules);
    }

    @PostMapping("/add")
    public Response addModule(@RequestBody MModule module, HttpSession session) {
        if (SessionUtil.validateUserLogin(session)) {
            return ResponseUtil.error("empty session");
        }
        SessionUser sessionUser = SessionUtil.getUser(session);
        module = moduleService.addModule(module, sessionUser.getId());
        if (module == null)
        {
            return ResponseUtil.error("add module failed");
        }
        return ResponseUtil.success(module);
    }
}
