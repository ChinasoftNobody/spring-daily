package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.model.library.MResource;
import com.lgh.spring.boot.service.library.ResourceService;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * library management
 */
@Controller
@RequestMapping("/library")
public class LibraryController {
    @Resource
    private ResourceService resourceService;

    @GetMapping("")
    public String index(Model model){
        List<MResource> resources = resourceService.queryExternalResource();
        model.addAttribute("resources",resources);
        return UiPath.setPath(model, "/library/index");
    }
}
