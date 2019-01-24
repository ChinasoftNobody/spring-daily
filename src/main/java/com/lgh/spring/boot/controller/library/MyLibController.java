package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.pojo.library.CreateDocRequest;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/library")
public class MyLibController {
    @GetMapping("/mylib")
    public String mylibIndex(Model model){
        return UiPath.setPath(model, "/library/mylib");
    }

    @PostMapping("/mylib/createDoc")
    @ResponseBody
    public String createDoc(CreateDocRequest request){
        //TODO 文件上传
        return "asd";
    }
}
