package com.example.conferenceDemo.repositories;

import com.example.conferenceDemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
