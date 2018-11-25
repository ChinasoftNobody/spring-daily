package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.model.MFeature;
import com.lgh.spring.boot.pojo.feature.Record;
import com.lgh.spring.boot.service.feature.FeatureService;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/feature")
public class FeatureController {

    @Resource
    private FeatureService featureService;

    @GetMapping("/{featureId}")
    public String index(Model model, @PathVariable("featureId") int featureId){
        MFeature feature = featureService.queryById(featureId);
        if (feature != null){
            model.addAttribute("feature", feature);
            List<Record> records = featureService.records(featureId);
            if (records != null && !records.isEmpty()){
                model.addAttribute("records", records);
            }
        }
        model.addAttribute("record", new Record());
        return UiPath.setPath(model,"/feature/index");
    }

    @PostMapping("/{featureId}/createRecord")
    public String createRecord(@PathVariable int featureId, @ModelAttribute Record record){
        featureService.createRecord(featureId, record);
        return "redirect:/feature/" + featureId;
    }
}
