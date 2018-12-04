package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.model.MFeature;
import com.lgh.spring.boot.model.MRecord;
import com.lgh.spring.boot.model.MTemplate;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.service.feature.FeatureService;
import com.lgh.spring.boot.service.login.UserService;
import com.lgh.spring.boot.service.template.TemplateService;
import com.lgh.spring.boot.util.UiPath;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/feature")
public class FeatureController {
    private static final Log LOG = LogFactory.getLog(FeatureController.class);

    @Resource
    private FeatureService featureService;
    @Resource
    private TemplateService templateService;

    @Resource
    private UserService userService;

    @GetMapping("/{featureId}")
    public String index(Model model, @PathVariable("featureId") int featureId) {
        MFeature feature = featureService.queryById(featureId);
        if (feature != null) {
            model.addAttribute("feature", feature);
            List<MRecord> records = featureService.records(featureId);
            if (records != null && !records.isEmpty()) {
                model.addAttribute("records", records);
            }
        }
        List<MUser> users = userService.queryAll();
        if (users == null) {
            users = Collections.emptyList();
        }
        List<MTemplate> templates = templateService.queryByFeatureId(featureId);
        if (templates != null && !templates.isEmpty())
        {
            model.addAttribute("template", templates.get(0));
        }
        model.addAttribute("users", users);
        return UiPath.setPath(model, "/feature/index", null, "/static/js/feature/index.js");
    }

    @PostMapping("/{featureId}/createRecord")
    public String createRecord(@PathVariable int featureId, @RequestParam HashMap<String, String> record) {
        featureService.createRecord(featureId, record);
        return "redirect:/feature/" + featureId;
    }

    @PostMapping("/{featureId}/deleteRecord/{recordId}")
    public String deleteRecord(@PathVariable int featureId, @PathVariable int recordId) {
        if (!featureService.deleteRecord(recordId)) {
            LOG.error("delete failed");
        }
        return "redirect:/feature/" + featureId;
    }
}
