package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class MyLibController {
    @GetMapping("/mylib")
    public String mylibIndex(Model model){
        return UiPath.setPath(model, "/library/mylib");
    }
}
