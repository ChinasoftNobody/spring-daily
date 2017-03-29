package com.lgh.spring.boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/1.
 */
@Controller
@RequestMapping(value = "/")
@Api(tags = "home")
public class HomeController {
    @ApiOperation(value = "index",notes = "index")
    @GetMapping(value = "/index")
    public String test(Model model){
        model.addAttribute("name","index");
        return "index";
    }
}
