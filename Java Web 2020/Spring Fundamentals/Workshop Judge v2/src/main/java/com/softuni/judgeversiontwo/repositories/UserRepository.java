package com.softuni.judgeversiontwo.repositories;

import com.softuni.judgeversiontwo.models.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);

    User findByUsername(String username);

    @Query("SELECT u.username,avg(c.score)FROM User u JOIN u.homeworks h  JOIN h.commentList c ")
    List<Object[]>getTopUsers();
}
