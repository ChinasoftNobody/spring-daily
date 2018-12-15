package com.lgh.spring.boot.service.clock.impl;

import com.lgh.spring.boot.model.MPlan;
import com.lgh.spring.boot.model.MPlanFragment;
import com.lgh.spring.boot.model.MVoiceClockMessage;
import com.lgh.spring.boot.service.clock.AlarmClockService;
import com.lgh.spring.boot.service.clock.VoiceClockCallable;
import com.lgh.spring.boot.service.clock.VoiceClockService;
import com.lgh.spring.boot.service.plan.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class AlarmCLockImplService implements AlarmClockService {
    @Resource
    private PlanService planService;
    @Resource
    private VoiceClockService voiceClockService;

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
                    int minutes = Integer.valueOf(times[1]);
                    Date now = new Date();
                    Date date = new Date();
                    date.setHours(hour);
                    date.setMinutes(minutes);
                    long timeDelay;
                    if (now.getTime() <= date.getTime()){
                        timeDelay = date.getTime()-now.getTime();
                    }else {
                        timeDelay = date.getTime() + 24*3600*1000 - now.getTime();
                    }
                    MVoiceClockMessage mVoiceClockMessage = new MVoiceClockMessage();
                    //pack message
                    mVoiceClockMessage.setVolTex(fragment.getSubject());
                    VoiceClockCallable command = new VoiceClockCallable(voiceClockService, mVoiceClockMessage);
                    scheduledExecutorService.scheduleAtFixedRate(command, timeDelay/1000/60, 24*60, TimeUnit.MINUTES);
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
