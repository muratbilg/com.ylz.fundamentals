package com.ylz.fundamentals.controllers;

import com.ylz.fundamentals.entities.Session;
import com.ylz.fundamentals.exceptions.ItemNotFoundException;
import com.ylz.fundamentals.services.SessionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
@Log4j2
public class SessionsController {
    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> list() {
        log.info("list method");

        return sessionService.list();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Session> get(@PathVariable Long id) {
        try {
            Session session = sessionService.get(id);

            return new ResponseEntity<Session>(session, HttpStatus.OK);
        } catch(ItemNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Session not found!");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session) {
        return sessionService.create(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Also check for children before deleting
        sessionService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        // this is a PUT, we expect all attributes to be passed in.
        // a PATCH would only need what we update
        // TODO: add validation..

        return sessionService.update(id, session);
    }
}
