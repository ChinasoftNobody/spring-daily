package com.lgh.spring.boot.service.schedule.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lgh.spring.boot.model.MEvent;
import com.lgh.spring.boot.repo.EventRepo;
import com.lgh.spring.boot.service.schedule.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    public JSONArray calendar(String month) {
        JSONArray result = new JSONArray();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date;
        try {
            date = format.parse(month);
        } catch (ParseException e) {
            date = new Date();
        }
        fillCalendar(result, date);
        return result;
    }

    private void fillCalendar(JSONArray result, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DATE, -dayOfWeek + 1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 42; i++) {
            JSONObject day = new JSONObject();
            day.put("day", calendar.get(Calendar.DATE));
            day.put("date", format.format(calendar.getTime()));
            result.add(day);
            calendar.add(Calendar.DATE, 1);
        }
    }


}
