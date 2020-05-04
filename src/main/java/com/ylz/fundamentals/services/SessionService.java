package com.ylz.fundamentals.services;

import com.ylz.fundamentals.entities.Session;
import com.ylz.fundamentals.exceptions.ItemNotFoundException;
import com.ylz.fundamentals.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> list() {
        return sessionRepository.findAll();
    }

    public Session get(Long id) {
        Optional<Session> session = sessionRepository.findById(id);

        if(session.isPresent())
            return session.get();
        else
            throw new ItemNotFoundException("Session not found!");
    }

    public Session create(Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    public void delete(Long id) {
        // Also check for children before deleting
        sessionRepository.deleteById(id);
    }

    public Session update(Long id, Session session) {
        // this is a PUT, we expect all attributes to be passed in.
        // a PATCH would only need what we update
        // TODO: add validation..
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");

        return sessionRepository.saveAndFlush(existingSession);
    }
}
