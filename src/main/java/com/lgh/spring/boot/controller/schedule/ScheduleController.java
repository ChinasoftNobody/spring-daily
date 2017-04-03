package com.lgh.spring.boot.controller.schedule;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.pojo.schedule.EstablishScheduleRequest;
import com.lgh.spring.boot.service.schedule.ScheduleService;
import com.lgh.spring.boot.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/3.
 * 日程
 */
@Api(tags = "schedule")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Resource
    private ScheduleService scheduleService;

    @PostMapping(value = "/establish")
    @ApiOperation(value = "create daily schedule",notes = "create daily schedule")
    public Response establish(@RequestBody EstablishScheduleRequest request){
        return scheduleService.establishSchedule(request);
    }

    @PostMapping(value = "/findAll")
    @ApiOperation(value = "find all daily schedule",notes = "find all daily schedule")
    public Response findAll(){
        return ResponseUtil.ok(scheduleService.findAll());
    }
}
