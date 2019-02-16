package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.library.CreateDocRequest;
import com.lgh.spring.boot.service.mylib.MyLibService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/library")
public class MyLibController {
    @Resource
    private MyLibService myLibService;


    @PostMapping("/mylib/createDoc")
    public Response createDoc(@Validated CreateDocRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseUtil.error("param error");
        }
        return myLibService.createDoc(request);
    }
}
