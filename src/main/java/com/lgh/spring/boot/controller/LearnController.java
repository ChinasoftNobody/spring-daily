package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/learn")
public class LearnController {

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("src", "https://gss0.baidu.com/6KAZsjip0QIZ8tyhnq/text2audio?tex=%E4%BD%A0%E6%9C%89%E4%B8%80%E6%9D%A1%E6%96%B0%E7%9A%84%E6%B6%88%E6%81%AF&cuid=baike&lan=ZH&ctp=1&pdt=31&vol=9&spd=4");
        return UiPath.setPath(model, "/learn/index");
    }
}
