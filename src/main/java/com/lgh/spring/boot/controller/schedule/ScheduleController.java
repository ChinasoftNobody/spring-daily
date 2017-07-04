package com.lgh.spring.boot.controller.schedule;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.model.MEvent;
import com.lgh.spring.boot.pojo.schedule.ScheduleQuery;
import com.lgh.spring.boot.pojo.schedule.WeekScheduleQuery;
import com.lgh.spring.boot.service.schedule.ScheduleService;
import com.lgh.spring.boot.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
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
    @ApiOperation(value = "create daily schedule", notes = "create daily schedule")
    public Response establish(@RequestBody MEvent event) {
        if (scheduleService.addEvent(event)) {
            return ResponseUtil.ok("add success");
        }
        return ResponseUtil.failed("add failed");
    }

    @PostMapping(value = "/query")
    @ApiOperation(value = "find daily schedule pageable", notes = "find daily schedule pageable")
    public Response query(@RequestBody ScheduleQuery request) {
        return ResponseUtil.ok(scheduleService.findByUserName(request.getUserName(), request.getPageNumber(), request.getPageSize()));
    }

    @PostMapping(value = "/week/schedule", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "当前用户本周日程", notes = "当前用户本周日程")
    public Response weekSchedule(@RequestBody WeekScheduleQuery weekScheduleQuery) {
        return ResponseUtil.ok(scheduleService.weekSchedule(weekScheduleQuery.getUserName()));
    }
}
