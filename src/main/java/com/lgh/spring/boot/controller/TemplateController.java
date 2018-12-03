package com.lgh.spring.boot.controller;

import com.lgh.spring.boot.model.MTemplate;
import com.lgh.spring.boot.model.MTemplateProperty;
import com.lgh.spring.boot.service.template.TemplateService;
import com.lgh.spring.boot.util.UiPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/feature")
public class TemplateController {
    @Resource
    private TemplateService templateService;

    @GetMapping("/{featureId}/template")
    public String index(@PathVariable("featureId") int featureId, Model model) {

        List<MTemplate> templates = templateService.queryByFeatureId(featureId);
        if (templates == null) {
            templates = Collections.emptyList();
        }
        model.addAttribute("templates", templates);
        model.addAttribute("template", new MTemplate());
        model.addAttribute("featureId", featureId);
        return UiPath.setPath(model, "/template/index");
    }

    @GetMapping("/{featureId}/template/{templateId}/property")
    public String property(@PathVariable("featureId") int featureId, @PathVariable("templateId") int templateId,
                           Model model) {
        MTemplate mTemplate = templateService.queryById(templateId);
        model.addAttribute("template", mTemplate);
        model.addAttribute("featureId", featureId);
        model.addAttribute("templateId", templateId);
        model.addAttribute("property", new MTemplateProperty());
        return UiPath.setPath(model, "/template/property");
    }

    @PostMapping("/{featureId}/template/{templateId}/property/create")
    public String createProperty(@PathVariable int featureId, @PathVariable int templateId,
                                 @ModelAttribute MTemplateProperty property) {
        templateService.createProperty(featureId, templateId, property);
        return "redirect:/feature/" + featureId + "/template/" + templateId + "/property";
    }

    @PostMapping("/{featureId}/template/{templateId}/property/{propertyId}/delete")
    public String deleteProperty(@PathVariable int featureId, @PathVariable int templateId,
                                 @PathVariable int propertyId) {
        templateService.deleteProperty(propertyId);
        return "redirect:/feature/" + featureId + "/template/" + templateId + "/property";
    }

    @PostMapping("/{featureId}/template/create")
    public String create(@PathVariable("featureId") int featureId, @ModelAttribute MTemplate template) {
        template.setFeatureId(featureId);
        templateService.create(template);
        return "redirect:/feature/" + featureId + "/template";
    }

    @PostMapping("/{featureId}/template/{templateId}/delete")
    public String delete(@PathVariable("featureId") int featureId, @PathVariable("templateId") int templateId) {
        templateService.deleteById(templateId);
        return "redirect:/feature/" + featureId + "/template";
    }
}
