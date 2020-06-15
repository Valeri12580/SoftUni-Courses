package com.softuni.judgeversiontwo.repositories;

import com.softuni.judgeversiontwo.models.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);

    User findByUsername(String username);

}
