package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.model.MPlan;
import com.lgh.spring.boot.service.plan.PlanService;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    @Resource
    private PlanService planService;

    @GetMapping("")
    public String index(Model model){
        List<MPlan> planList = planService.queryAllPlans();
        model.addAttribute("plans", planList);
        return UiPath.setPath(model, "/plan/index");
    }

    @PostMapping("/addPlan")
    public String addPlan(MPlan plan){
        planService.addPlan(plan);
        return "redirect:/plan";
    }
}
