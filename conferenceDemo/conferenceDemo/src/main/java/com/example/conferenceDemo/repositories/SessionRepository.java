package com.example.conferenceDemo.repositories;

import com.example.conferenceDemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
