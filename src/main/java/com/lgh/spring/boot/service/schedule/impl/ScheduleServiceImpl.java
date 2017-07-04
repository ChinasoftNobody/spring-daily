package com.lgh.spring.boot.service.schedule.impl;

import com.lgh.spring.boot.common.DateFormat;
import com.lgh.spring.boot.model.MEvent;
import com.lgh.spring.boot.pojo.schedule.WeekScheduleResponse;
import com.lgh.spring.boot.repo.EventRepo;
import com.lgh.spring.boot.service.schedule.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 * 日程服务实现
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private EventRepo eventRepo;

    @Override
    public Page<MEvent> findByUserName(String userName, int pageNumber, int pageSize) {
        pageNumber = pageNumber < 0 ? 1 : pageNumber;
        pageSize = pageSize < 0 ? 10 : pageSize;
        return eventRepo.findByUserName(userName, new PageRequest(pageNumber, pageSize));
    }

    @Override
    public boolean addEvent(MEvent event) {
        MEvent event1 = eventRepo.save(event);
        return event1 != null;
    }

    @Override
    public List<WeekScheduleResponse> weekSchedule(String userName) {
        List<WeekScheduleResponse> responses = new ArrayList<>();
        if (StringUtils.isEmpty(userName)) {
            return responses;
        }
        List<MEvent> events = eventRepo.findByUserName(userName);
        for (MEvent event : events) {
            WeekScheduleResponse response = new WeekScheduleResponse();
            String weekDay = transWeekDay(event.getStartTime());
            if (!StringUtils.isEmpty(weekDay)) {
                response.setWeekNumber(weekDay);
                //TODO 组装日程树结构
            }
        }
        return responses;
    }

    /**
     * 计算日期是否存在本周，如果是本周，计算出本周几，否则返回null
     *
     * @param startTime 时间
     * @return
     */
    public String transWeekDay(String startTime) {
        try {
            Date date = DateFormat.DATE_TIME_FORMAT.parse(startTime);
            if (Math.abs(date.compareTo(new Date())) > 6) {
                return null;
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                return transWeek(dayOfWeek);
            }
        } catch (ParseException e) {
            return null;
        }
    }

    private String transWeek(int dayOfWeek) {
        String s = "";
        switch (dayOfWeek) {
            case 1:
                s = "周日";
                break;
            case 2:
                s = "周一";
                break;
            case 3:
                s = "周二";
                break;
            case 4:
                s = "周三";
                break;
            case 5:
                s = "周四";
                break;
            case 6:
                s = "周五";
                break;
            case 7:
                s = "周六";
                break;
        }
        return s;
    }
}
