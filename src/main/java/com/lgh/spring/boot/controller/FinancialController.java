package com.lgh.spring.boot.controller;

import com.github.pagehelper.Page;
import com.lgh.spring.boot.annotation.Fragment;
import com.lgh.spring.boot.model.MRecord;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.finance.RecordQuery;
import com.lgh.spring.boot.service.financial.FinancialService;
import com.lgh.spring.boot.service.login.UserService;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 财务管理
 */
@Controller
@RequestMapping("/finance")
public class FinancialController {
    @Resource
    private FinancialService financialService;
    @Resource
    private UserService userService;

    @GetMapping("")
    public String index(Model model){
        Page<MRecord> recordPage = financialService.queryAll();
        List<MUser> users = userService.queryAll();
        model.addAttribute("recordPage", recordPage);
        model.addAttribute("users", users);
        return UiPath.setPath(model, "/finance/index",null,"/static/js/financial/index.js");
    }

    @PostMapping(value = "/addRecord")
    public String addRecord(MRecord record){
        financialService.addRecord(record);
        return "redirect:/finance";
    }

    @PostMapping("/queryByFilter")
    @Fragment
    public String queryByFilter(Model model, RecordQuery query){
        Page<MRecord> records = financialService.queryByFilter(query);
        model.addAttribute("data", records);
        return "/common/table::table";
    }
}
