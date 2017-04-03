package com.lgh.spring.boot.service.schedule.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.model.MCalender;
import com.lgh.spring.boot.model.MSchedule;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.schedule.EstablishScheduleRequest;
import com.lgh.spring.boot.repo.schedule.UserRepo;
import com.lgh.spring.boot.service.schedule.ScheduleService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/3.
 *  日程服务实现
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private UserRepo userRepo;

    @Override
    public Response establishSchedule(EstablishScheduleRequest request) {
        MCalender calender = new MCalender();
        calender.setDate(request.getDate());
        MSchedule schedule = new MSchedule();
        schedule.setTimeFrom(request.getTimeFrom());
        schedule.setTimeTo(request.getTimeTo());
        schedule.setGoal(request.getGoal());
        calender.getSchedules().add(schedule);
        MUser user = new MUser();
        user.setName(request.getUser());
        user.getCalenders().add(calender);
        calender.getUsers().add(user);
        schedule.getCalenders().add(calender);
        MUser mUser = userRepo.save(user);
        if(mUser == null){
            return ResponseUtil.failed("save error");
        }
        return ResponseUtil.ok("save ok");
    }

    @Override
    public JSONArray findAll() {
        List<MUser> users = userRepo.findAll();
        JSONArray result = new JSONArray();
        for (MUser user:users){
            JSONObject userItem = new JSONObject();
            JSONArray calenders = new JSONArray();
            userItem.put("user",user.getName());
            userItem.put("userId",user.getId());
            for (MCalender calender:user.getCalenders()){
                JSONObject calenderItem = new JSONObject();
                JSONArray schedules = new JSONArray();
                calenderItem.put("calenderId",calender.getId());
                calenderItem.put("calenderName",calender.getDate());
                for(MSchedule schedule:calender.getSchedules()){
                    JSONObject scheduleItem = new JSONObject();
                    scheduleItem.put("scheduleId",schedule.getId());
                    scheduleItem.put("timeFrom",schedule.getTimeFrom());
                    scheduleItem.put("timeTo",schedule.getTimeTo());
                    scheduleItem.put("goal",schedule.getGoal());
                    schedules.add(scheduleItem);
                }
                calenderItem.put("schedules",schedules);
                calenders.add(calenderItem);
            }
            userItem.put("calenders",calenders);
            result.add(userItem);
        }
        return result;
    }
}
