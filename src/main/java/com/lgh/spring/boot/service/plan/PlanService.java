package com.lgh.spring.boot.service.plan;

import com.lgh.spring.boot.model.MPlan;

import java.util.List;

public interface PlanService {
    void addPlan(MPlan plan);

    List<MPlan> queryAllPlans();

    List<MPlan> queryAlarmPlans();
}
