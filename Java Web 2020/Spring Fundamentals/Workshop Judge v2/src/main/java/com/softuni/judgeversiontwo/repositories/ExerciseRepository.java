package com.softuni.judgeversiontwo.repositories;

import com.softuni.judgeversiontwo.models.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ExerciseRepository  extends JpaRepository<Exercise,Long> {

    Exercise findByName(String name);

    List<Exercise> findByDueTimeIsBefore(LocalDateTime date);
}
