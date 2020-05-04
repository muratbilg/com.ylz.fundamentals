package com.ylz.fundamentals.controllers;

import com.ylz.fundamentals.entities.Session;
import com.ylz.fundamentals.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> list() {
        return sessionService.list();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionService.get(id);
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
