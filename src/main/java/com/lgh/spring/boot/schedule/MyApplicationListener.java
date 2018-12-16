package com.lgh.spring.boot.schedule;

import com.lgh.spring.boot.service.clock.AlarmClockService;
import com.lgh.spring.boot.service.clock.VoiceClockService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Resource
    private AlarmClockService alarmClockService;
    @Resource
    private VoiceClockService voiceClockService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //init clock service
        voiceClockService.start();
        //Plan Alarm clock
        alarmClockService.startPlanAlarmClock();
    }
}
