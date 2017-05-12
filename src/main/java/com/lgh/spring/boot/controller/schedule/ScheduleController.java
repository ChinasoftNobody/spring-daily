package com.lgh.spring.boot.controller.schedule;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.pojo.schedule.EstablishScheduleRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/3.
 * 日程
 */
@Api(tags = "schedule")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @PostMapping(value = "/establish")
    @ApiOperation(value = "create daily schedule",notes = "create daily schedule")
    public Response establish(@RequestBody EstablishScheduleRequest request){
        return null;
    }

    @PostMapping(value = "/findAll")
    @ApiOperation(value = "find all daily schedule",notes = "find all daily schedule")
    public Response findAll(){
        return null;
    }
}
