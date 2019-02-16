package com.lgh.spring.boot.common;

import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleBindException(MethodArgumentNotValidException ex) {
        StringBuilder stringBuilder = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach((item) -> stringBuilder.append(item.getDefaultMessage()).append("\n"));
        return ResponseUtil.error(stringBuilder.toString());
    }
}
