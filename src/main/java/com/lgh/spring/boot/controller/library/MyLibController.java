package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.library.CreateDocRequest;
import com.lgh.spring.boot.service.mylib.MyLibService;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/library")
public class MyLibController {
    @Resource
    private MyLibService myLibService;

    @GetMapping("/mylib")
    public String mylibIndex(Model model){
        model.addAttribute("docs",myLibService.findAll());
        return UiPath.setPath(model, "/library/mylib");
    }

    @PostMapping("/mylib/createDoc")
    @ResponseBody
    public Response createDoc(CreateDocRequest request){
        return myLibService.createDoc(request);
    }
}
