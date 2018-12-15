package com.lgh.spring.boot.service.plan.impl;

import com.lgh.spring.boot.mapper.PlanMapper;
import com.lgh.spring.boot.model.MPlan;
import com.lgh.spring.boot.model.MPlanFragment;
import com.lgh.spring.boot.service.plan.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Resource
    private PlanMapper planMapper;

    @Override
    public void addPlan(MPlan plan) {
        planMapper.createPlan(plan);
        if (plan.getFragments() != null && !plan.getFragments().isEmpty()){
            for (MPlanFragment fragment: plan.getFragments()){
                fragment.setPlanId(plan.getId());
            }
            planMapper.createFragments(plan.getFragments());
        }
    }

    @Override
    public List<MPlan> queryAllPlans() {
        return planMapper.queryAllPlans();
    }

    @Override
    public List<MPlan> queryAlarmPlans() {
        return queryAllPlans();
    }
}
