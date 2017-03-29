package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.common.Response;
import com.lgh.spring.boot.pojo.TestRequest;
import com.lgh.spring.boot.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/1.
 */
@RestController
@RequestMapping(value = "/test")
@Api(tags = "test")
public class TestController {

    @ApiOperation(value = "test1",notes = "test1")
    @GetMapping(value = "/test1",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response test(){
        return ResponseUtil.ok("test data 1");
    }

    @ApiOperation(value = "test1",notes = "test1")
    @PostMapping(value = "/test2",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response test2(@RequestBody TestRequest request){
        return ResponseUtil.ok("test data 2 " + request.getName());
    }
}
