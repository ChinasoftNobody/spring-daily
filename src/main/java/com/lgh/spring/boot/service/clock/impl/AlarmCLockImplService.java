package com.lgh.spring.boot.service.clock.impl;

import com.lgh.spring.boot.model.MPlan;
import com.lgh.spring.boot.model.MPlanFragment;
import com.lgh.spring.boot.service.clock.AlarmClockService;
import com.lgh.spring.boot.service.plan.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AlarmCLockImplService implements AlarmClockService {
    @Resource
    private PlanService planService;

    @Override
    public void startPlanAlarmClock() {
        //search from table info to start time job
        List<MPlan> plans = planService.queryAlarmPlans();
        for (MPlan plan:plans){
            if (plan.getFragments() == null || plan.getFragments().isEmpty()) {
                continue;
            }
            if (!"On".equals(plan.getStatus())){
                continue;
            }
            for (MPlanFragment fragment:plan.getFragments()){
                if (!fragment.isUp()){
                    continue;
                }
                //TODO schedule alarm clock
            }
        }
    }
}
