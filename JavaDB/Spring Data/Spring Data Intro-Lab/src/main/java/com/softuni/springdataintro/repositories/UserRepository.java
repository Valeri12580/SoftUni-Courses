package com.softuni.springdataintro.repositories;

import com.softuni.springdataintro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User getUserByUsername(String username);
}
