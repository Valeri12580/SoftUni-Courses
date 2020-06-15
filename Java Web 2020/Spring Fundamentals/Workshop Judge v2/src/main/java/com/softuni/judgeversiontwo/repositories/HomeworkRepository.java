package com.softuni.judgeversiontwo.repositories;

import com.softuni.judgeversiontwo.models.entities.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework,Long> {
}
