package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.library.CreateDocRequest;
import com.lgh.spring.boot.service.mylib.MyLibService;
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
    public Response createDoc(CreateDocRequest request){
        return myLibService.createDoc(request);
    }
}
