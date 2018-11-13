package com.lgh.spring.boot.util;

import org.springframework.ui.Model;

public class UiPath {

    public static String setPath(Model model, String path) {
        return setPath(model, path, null, null);
    }

    public static String setPath(Model model, String path, String cssPaths, String jsPaths) {
        model.addAttribute("uiPath", path == null ? "" : path);
        model.addAttribute("cssPaths", cssPaths == null ? "" : cssPaths);
        model.addAttribute("jsPaths", jsPaths == null ? "" : jsPaths);
        return "index";
    }
}
