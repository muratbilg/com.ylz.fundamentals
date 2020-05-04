package com.ylz.fundamentals.repositories;

import com.ylz.fundamentals.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
