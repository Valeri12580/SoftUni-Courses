package com.softuni.judgeversiontwo.repositories;

import com.softuni.judgeversiontwo.models.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
