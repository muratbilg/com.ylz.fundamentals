package com.ylz.fundamentals.services;

import com.ylz.fundamentals.entities.Speaker;
import com.ylz.fundamentals.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService {
    @Autowired
    private SpeakerRepository speakerRepository;

    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    public Speaker get(Long id) {
        return speakerRepository.getOne(id);
    }
}
