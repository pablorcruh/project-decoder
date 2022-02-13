package com.ead.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<LessonRepository, UUID> {
}
