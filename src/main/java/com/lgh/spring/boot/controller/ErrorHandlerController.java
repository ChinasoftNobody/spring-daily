package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(value = Throwable.class)
    public Response<String> serverError(Throwable e){
        return ResponseUtil.error(e.getMessage());
    }
}
