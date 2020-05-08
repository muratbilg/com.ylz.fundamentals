package com.ylz.fundamentals.controllers;

import com.ylz.fundamentals.entities.Speaker;
import com.ylz.fundamentals.services.SpeakerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
@Log4j2
public class SpeakersController {
    @Autowired
    private SpeakerService speakerService;

    @GetMapping
    public List<Speaker> list() {
        return speakerService.list();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerService.get(id);
    }
}
