package com.lgh.spring.boot.service.clock.impl;

import com.lgh.spring.boot.model.MPlan;
import com.lgh.spring.boot.model.MPlanFragment;
import com.lgh.spring.boot.service.clock.AlarmClockService;
import com.lgh.spring.boot.service.plan.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class AlarmCLockImplService implements AlarmClockService {
    @Resource
    private PlanService planService;

    private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

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
                // schedule alarm clock
                String startTime = fragment.getTimeStart();
                try {
                    String[] times = startTime.split(":");
                    if (times.length != 2){
                        continue;
                    }
                    int hour = Integer.valueOf(times[0]);
                    int munite = Integer.valueOf(times[1]);
                    scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                        @Override
                        public void run() {
                            //TODO write message to table;
                        }
                    }, 0, 1, TimeUnit.MINUTES);
                }catch (NumberFormatException e){
                    continue;
                }
            }
        }
    }
}
