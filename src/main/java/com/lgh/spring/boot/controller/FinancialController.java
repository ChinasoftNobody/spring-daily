package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 财务管理
 */
@Controller
@RequestMapping("/finance")
public class FinancialController {


    @GetMapping("/")
    public String index(Model model){

        return UiPath.setPath(model, "/finance/index");
    }
}
