package com.ylz.fundamentals.repositories;

import com.ylz.fundamentals.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
