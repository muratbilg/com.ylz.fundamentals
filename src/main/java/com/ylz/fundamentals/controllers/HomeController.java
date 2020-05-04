package com.ylz.fundamentals.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

    @Value("${app.env}")
    private String appEnvironment;

    @GetMapping
    @RequestMapping("/")
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        map.put("app-env", appEnvironment);
        map.put("app-name", "com.pluralsight.conferencedemo");

        return map;
    }
}
