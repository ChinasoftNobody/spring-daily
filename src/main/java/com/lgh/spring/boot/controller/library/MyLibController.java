package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.annotation.Fragment;
import com.lgh.spring.boot.mongo.model.mylib.MDoc;
import com.lgh.spring.boot.pojo.common.PageKeywordQuery;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.library.CreateDocRequest;
import com.lgh.spring.boot.service.mylib.MyLibService;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.data.domain.Page;
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
        return UiPath.setPath(model, "/library/mylib");
    }
    @PostMapping("/mylib/query")
    @Fragment
    public String query(Model model, PageKeywordQuery query){
        Page<MDoc> docPage = myLibService.find(query);
        model.addAttribute("docs", docPage);
        return "/library/mylib/doc-list";
    }

    @PostMapping("/mylib/createDoc")
    @ResponseBody
    public Response createDoc(CreateDocRequest request){
        return myLibService.createDoc(request);
    }
}
